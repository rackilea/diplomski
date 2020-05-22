System.out.println("***********ASMHelper.TypeHelperClassLoader.defineClass(): " + name.replace('/', '.'));
        try {
            java.io.FileOutputStream fos = new java.io.FileOutputStream(name.replace('/', '.') + ".class");
            fos.write(bytes);
            fos.close();
        } catch (java.io.IOException ioe) {
            ioe.printStackTrace();
        }