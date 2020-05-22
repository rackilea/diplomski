String pathToPackageBase = pathToClassFile.substring(0, pathToClassFile.length() - (classname + ".class").length());
System.out.println("pathToPackagBase = " + pathToPackageBase);
Class clss = new URLClassLoader(
        new URL[]{new File(pathToPackageBase).toURI().toURL()}
).loadClass(classname);
System.out.println(clss.newInstance().toString());