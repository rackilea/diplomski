public void setName(String name) {
    String uppercaseName = name.toUppercase();

    // delegate the task with the uppercase name
    ftpFile.setName(uppercaseName);
}