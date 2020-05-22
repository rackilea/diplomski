public static void populateFile(int fileNumber, int startNumber) 
    throws IOException, BiffException {
        BufferedWriter bw = setFile(fileNumber);
        Sheet s = getSheet();
        Cell[] row = null;
        writeRow(bw,s.getRow(0));
        bw.newLine(); 
        int limit = getLimit(s,startNumber);
        System.out.println("End Number:" + limit);
        System.out.println();
        for (int i = startNumber; i < limit ; i++) {
            row = s.getRow(i); 
            //System.out.println(i);
            writeRow(bw,row);
            bw.newLine();
        }
        bw.flush();
        bw.close();
    }