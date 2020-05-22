if (selectedFile != null) {

    try {
        Files.copy(
            selectedFile.toPath(), 
            new File("E:/new.txt").toPath(), 
            StandardCopyOption.REPLACE_EXISTING);
    } catch (IOException ex) {
        ex.printStackTrace();
    }

}