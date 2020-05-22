public void downloadJar() {
    String absolutePath = getPath();
    String from = absolutePath + "\\temp\\test.txt";
    String to = absolutePath + "\\test.txt";
    File fileTo = new File(to);
    File fileFrom = new File(from);


    try {
        FileUtils.moveFile(fileFrom, fileTo);
        JOptionPane.showMessageDialog(null, "test");
    } catch (IOException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
        JOptionPane.showMessageDialog(null, "io exce");
    }

}

public String getPath() {
    return System.getProperty("user.dir");
}