public static void main(String[] args) throws Exception {
    java.io.File filer = new java.io.File("RESULT.txt");
    System.out.println("Choose the location of the data file");
    JFileChooser fileCh = new JFileChooser();
    java.io.File filed = null;

    if (fileCh.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
        filed = fileCh.getSelectedFile();
    } else {
        System.out.println("No file choosen.");
        System.exit(1);

    }
    Scanner finput = new Scanner(filed);
}