public static BufferedWriter setFile(int fileNumber) throws IOException {
    String csvFilename = directory + "file-"+ fileNumber +".csv";
    FileWriter csvFile = new FileWriter(csvFilename);
    BufferedWriter bw = new BufferedWriter(csvFile);
    return bw;
}