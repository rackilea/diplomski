public void readAndWriteFromfile() throws IOException {
    BufferedReader inputStream = new BufferedReader(new FileReader(
            "original.txt"));
     File UIFile = new File("numbers.txt");
        // if File doesnt exists, then create it
        if (!UIFile.exists()) {
            UIFile.createNewFile();
        }
    FileWriter filewriter = new FileWriter(UIFile.getAbsoluteFile());
    BufferedWriter outputStream= new BufferedWriter(filewriter);
    String count;
    while ((count = inputStream.readLine()) != null) {
        outputStream.write(count);
    }
    outputStream.flush();
    outputStream.close();
    inputStream.close();