public ProgramLog() {

    try {
        String path = System.getProperty("user.home") + File.separator
                + "AppData" + File.separator + "Local" + File.separator
                + "CompanyName" + File.separator + "CompanyProduct" + File.separator;

        File f = new File(path);
        f.mkdirs();

        FileHandler handler = new FileHandler(path + logFile);
        logger = Logger.getLogger("com.program.msgs");
        logger.addHandler(handler);

    } catch (Exception e) {
    }
}