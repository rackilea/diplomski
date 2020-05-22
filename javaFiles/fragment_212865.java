package com.vkg;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class DummyClass {
    public void classLoader() {
        ClassLoader classLoader = new ClassLoader() {
            public Class<?> loadClass(String classNameWithPackage) throws ClassNotFoundException {
                 if(!classNameWithPackage.contains("DummyClass")) {
                     return  super.loadClass(classNameWithPackage);
                 } 
                 String className = classNameWithPackage.replace('.', '/') + ".class";
                byte[] classData = null;
                try {
                    InputStream inputStream = getResourceAsStream(className);
                    byte[] buffer = new byte[1];
                    ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
                    int bytesRead = -1;
                    while ((bytesRead = inputStream.read(buffer, 0, 1)) != -1) {
                        outputStream.write(buffer, 0, bytesRead);
                    }
                    classData = outputStream.toByteArray();
                }
                catch (IOException e) {
                    e.printStackTrace();
                }

                Class<?> c = defineClass(classNameWithPackage, classData, 0, classData.length);
                resolveClass(c);
                System.out.println("Steve I am loading another copy of Dummy class. Soon Permgen will fill.");
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