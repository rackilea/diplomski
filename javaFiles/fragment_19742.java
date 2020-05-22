public static void main(String[] args) {

    File fileToOpen = null;

    ReadIn openLog = new ReadIn();

    fileToOpen = openLog.openFile();    // ***

    System.out.println(fileToOpen);

}