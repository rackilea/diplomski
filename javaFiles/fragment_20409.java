public ArrayList<Integer> find(String word, File text) throws IOException {
    LineNumberReader rdr = new LineNumberReader(new FileReader(text));
    ArrayList<Integer> results = new ArrayList<Integer>();
    try {
        String line = rdr.readLine();
        while(line != null){
        if (line.contains(word)) {        
            results.add(rdr.getLineNumber());
        }
        line = rdr.readLine();
        }
    } finally {
        rdr.close();
    }
    return results;
}