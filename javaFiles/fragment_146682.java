private boolean searchFromRecord(String recordName, String word) throws IOException {
    // Please write your code after this line
    Boolean wordFound = false;  // indicates if word exists in recordFile.
    File file = new File(recordName);   // file at path "recordName"
    Scanner scanner = new Scanner(file);    // reads records from "file"

    // iterate through the recordFile, to see if "word" already exists
    // within recordFile.
    for(int i = 0; scanner.hasNextLine(); i++) {

        // read the record from the file
        String compare = scanner.nextLine();
        IO.outputln("word#" + i + ":" + compare);

        // compare the record with our word
        if (compare.equals(word)){
            wordFound = true;
            break;      // bail out of loop, our work here is done
        }
    }

    // clean up, and return...
    scanner.close();
    return wordFound;
}