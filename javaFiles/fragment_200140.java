int returnVal = exportChooser.showDialog(null, "Export");
if (returnVal == JFileChooser.APPROVE_OPTION) {
    File file = exportChooser.getSelectedFile();
    File path = file.getParentFile();
    String name = file.getName();
    if (!name.toUpperCase().endsWith(".txt")) {
        name += ".txt";
    }
    String metaName = name.substring(0, name.lastIndexOf("."));
    metaName += "_metadata.txt";

    File outputFile = new File(path, name);
    File metaFile = new File(path, metaName);
}