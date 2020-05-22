public static void writeRow(BufferedWriter bw, Cell[] row) throws IOException { 
    if (row.length > 0) {
        bw.write(row[0].getContents());
        for (int j = 1; j < row.length; j++) {
            bw.write(',');
            bw.write(row[j].getContents());
        }
    }
}