public static void main(String[] args) throws BiffException, IOException {
Sheet s = getSheet();
    int countRows = s.getRows(); // counts the number of rows in the sheet.
    int numberOfFiles = (countRows/maxRecords)+1;

    for(int file=0; file<numberOfFiles; file++) {
        System.out.println("Create file number " + (file+1));
        int fileNumber = file+1;
        System.out.println("Start number: " + ((file*maxRecords)+1));
        int startNumber = (file*maxRecords);
        populateFile(fileNumber,startNumber);
        System.out.println("");
    }
}