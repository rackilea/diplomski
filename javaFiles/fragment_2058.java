JFileChooser fileChooser = new JFileChooser();
File selectedFile = fileChooser.getSelectedFile();

if (selectedFile != null) {

    String givenExtension = FilenameUtils.getExtension(selectedFile.getName());

    boolean noExtension = "".equals(givenExtension);
    boolean xlsx = givenExtension.toLowerCase().contains("xlsx");
    boolean xls = givenExtension.toLowerCase().contains("xls");

    String newFileName = selectedFile.getName();

    if (noExtension) {
        newFileName += ".xlsx";
    } else if (!xlsx && !xls) {
        throw new Exception("Invalid name");
    }
}