try {
        System.setProperty("java.library.path","YOUR/PATH");
        Field fieldSysPath = ClassLoader.class.getDeclaredField("sys_paths");
        fieldSysPath.setAccessible(true);
        fieldSysPath.set(null, null);
    } catch (Exception ex) {
        System.out.println("Failed to set Java Library Path: " + ex.getMessage);
    }