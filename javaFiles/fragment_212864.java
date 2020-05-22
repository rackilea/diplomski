package com.vkg;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class ClassGenerator {
    private static final int BUFFER = 1024;
    private List<Class<?>> classList = new ArrayList<Class<?>>();

    public static void main(String[] args) {
        ClassGenerator classGenerator = new ClassGenerator();
        // Load just some class with class loaders until perm gen space fills.
        while (true) {
            classGenerator.classLoader();
        }
    }

    private void classLoader() {
        ClassLoader classLoader = new ClassLoader() {
            public Class<?> loadClass(String classNameWithPackage)
                    throws ClassNotFoundException {
                if (!classNameWithPackage.contains("DummyClass")) {
                    return super.loadClass(classNameWithPackage);
                }
                String className = classNameWithPackage.replace('.', '/')
                        + ".class";
                byte[] classData = null;
                InputStream inputStream = null;
                try {
                    inputStream = getResourceAsStream(className);
                    byte[] buffer = new byte[BUFFER];
                    ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
                    int bytesRead = -1;
                    while ((bytesRead = inputStream.read(buffer, 0, BUFFER)) != -1) {
                        outputStream.write(buffer, 0, bytesRead);
                    }
                    classData = outputStream.toByteArray();
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
                Class<?> c = defineClass(classNameWithPackage, classData, 0,
                        classData.length);
                resolveClass(c);
                System.out
                        .println("Steve I am loading another copy of Dummy class. Soon Permgen will fill.");
                classList.add(c);
                return c;
            }
        };

        try {
            Class.forName("com.vkg.DummyClass", true, classLoader);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}