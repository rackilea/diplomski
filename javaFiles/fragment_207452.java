public class C {
    public static void main(String[] args) throws java.io.IOException {
        java.util.jar.JarFile jar = new java.util.jar.JarFile(args[0]);
        java.util.Enumeration<java.util.jar.JarEntry> jarEntries = jar.entries();
        while (jarEntries.hasMoreElements()) {
            java.util.jar.JarEntry jarEntry = jarEntries.nextElement();
            String jarEntryName = jarEntry.getName();
            if (!jarEntryName.endsWith(".class")) {
                continue;
            }
            int jarEntryNameSuffixIndex = jarEntryName.length() - 6;
            String binaryName = jarEntryName.substring(0, jarEntryNameSuffixIndex).replaceAll("/", "\\.");
            Class<?> type = null;
            while (type == null) {
                try {
                    type = ClassLoader.getSystemClassLoader().loadClass(binaryName);
                } catch (ClassNotFoundException e) {
                    int binaryNameQualifiedIndex = binaryName.indexOf(".");
                    if (binaryNameQualifiedIndex == -1) {
                        throw new RuntimeException("couldn't load class for " + jarEntryName);
                    } else {
                        binaryName = binaryName.substring(binaryNameQualifiedIndex + 1);
                    }
                }
            }
            int typeModifiers = type.getModifiers();
            if (!(java.lang.reflect.Modifier.isPublic(typeModifiers) || java.lang.reflect.Modifier.isProtected(typeModi$
                continue;
            }
            String packageName = (type.getPackage() == null) ? "" : type.getPackage().getName();
            String typeName = type.getCanonicalName();
            for (java.lang.reflect.Method method : type.getDeclaredMethods()) {
                if (method.isSynthetic() || method.isBridge()) {
                    continue;
                }
                int methodModifiers = method.getModifiers();
                if (!(java.lang.reflect.Modifier.isPublic(methodModifiers) || java.lang.reflect.Modifier.isProtected(me$
                    continue;
                }
                String methodName = method.getName();
                System.out.print(packageName + ", " + typeName + ", " + methodName + ", ");
                for (Class<?> parameterType : method.getParameterTypes()) {
                    String parameterTypeName = parameterType.getCanonicalName();
                    System.out.print(":" + parameterTypeName + ", ");
                }
                Class<?> returnType = method.getReturnType();
                String returnTypeName = returnType.getCanonicalName();
                System.out.println(returnTypeName);
            }
        }
    }
}