public static void main(String args[]) {
    Runtime rt = Runtime.getRuntime();
    try {
        Process pr = rt.exec("D:\\test1.bat", null, new File("D:\\"));
        pr.waitFor();
    } catch (Exception e) {
        e.printStackTrace();
    }
}