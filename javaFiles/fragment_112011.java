String osName = System.getProperty("os.name");
    if (osName.toLowerCase().startsWith("windows")) {
        // we change the temp directory because sometimes Windows is stupid and doesn't want to load jna.dll from the temp directory
        File tempDir = new File(System.getenv("USERPROFILE") + "\\AppData\\Local\\MyCompany\\temp");
        System.out.println("Using temp dir: " + tempDir.getPath());
        tempDir.mkdirs();
        System.setProperty("java.io.tmpdir", tempDir.getPath());
    }