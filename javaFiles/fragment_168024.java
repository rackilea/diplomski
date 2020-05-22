public void setTrailer(File file) throws Exception {
        FileReader fReader = new FileReader(file);
        BufferedReader bReader = new BufferedReader (fReader);
        String currLine = new String();
        readLoop:
            while (bReader.ready()) {
                currLine = bReader.readLine();
                if (currLine.contains(TRAILER_E) || currLine.contains(TRAILER_R)) {
                    break readLoop;
                }
            }
        this.trailerRecord = currLine.trim();
        System.out.println("From setTrailer(): " + this.trailerRecord);
        fReader.close();
        bReader.close();
}