public static void main(String[] args) {
    File sysdir = new File("C:/Windows/System32/oobe/info");
    for(File file:sysdir.listFiles()) {
        System.out.println(file.getName());
    }
}