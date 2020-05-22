public String[] sameLocation(String s) throws IOException {
    BufferedReader br = new BufferedReader(new FileReader(
            "M:/NetBeans Projects/MovieList/src/MovieInfo.txt"));
    String line = "";
    List<String> al = new ArrayList<String>();
    if (s != null) {
        while ((line = br.readLine()) != null) {
            for (int i = 0; i < 6; i++) { // <-- Why 6?
                al.add(line);
            }
        }
    }
    if (al.size() > 0) {
        String [] out = new String[al.size()];
        return al.toArray(out);
    } else {
        return null;
    }
}