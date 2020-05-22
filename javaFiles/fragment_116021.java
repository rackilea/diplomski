public static void main(String[] args) {
    String XLS_PPT_FILE = "D:\\xxx\\Excel\\yyyy\\config_wdiCore_20_2.xls";
    int pos = XLS_PPT_FILE.lastIndexOf('\\');
    String baseName = (pos > -1) ? XLS_PPT_FILE.substring(pos + 1)
            : XLS_PPT_FILE;
    pos = baseName.indexOf(".xls");
    if (pos > -1) {
        baseName = baseName.substring(0, pos);
    }
    String[] parts = baseName.split("\\_", 3);
    System.out.printf("module: %s%nversion: %s%n", parts[1], parts[2]);
}