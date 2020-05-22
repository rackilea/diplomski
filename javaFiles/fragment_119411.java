public static void main(String[] args) throws SQLException {
    File in = new File("C:\\path\\to\\input.txt");
    File out = new File("C:\\path\\to\\output.txt");
    BufferedReader br = null;
    BufferedWriter bw = null;
    try {
        br = new BufferedReader(new FileReader(in));
        bw = new BufferedWriter(new FileWriter(out));
        String header = "";

        do {
            String line = br.readLine();
            if (line == null) break;
            int numCommas = line.length() - line.replace(",", "").length();
            if (numCommas == 1) {
                header = line;
            }
            else {
                bw.write(header + ", " + line);
                bw.newLine();
            }
        } while (true);
    } catch (IOException e) {
        e.printStackTrace();
    } finally {
        try {
            if (br != null) br.close();
            if (bw != null) bw.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}