StringReader sr = new StringReader(yourString);
List<Integer> list = new ArrayList<>();
try (BufferedReader br = new BufferedReader(sr)) {
    String line;
    while ((line = br.readLine()) != null) {
        if (line.equals("sat")) {
            list.add(1);
        } else if (line.equals("unsat")) {
            list.add(0);
        }
    }
} catch (IOException e) {
    //handle exception
}