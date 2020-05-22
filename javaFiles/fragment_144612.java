public static void main(String[] arg) throws Exception {
        String p = System.getProperty("java.util.logging.config.file");
        System.out.println(p);
        System.out.println(new File(p).length());
        System.out.println(Logger.getLogger("").getLevel());
    }