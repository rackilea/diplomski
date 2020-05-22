BufferedReader br = new BufferedReader(new FileReader("input.txt"));
int lineCount = readLines();

ArrayList<ArrayList<String>> rows = new ArrayList<ArrayList<String>>(lineCount);
for (int i = 0; i < lineCount; i++) {
    ArrayList<String> row = new ArrayList<String>();
    String line = br.readLine();
    for(String s: line.split(",")) {
        row.add(s);
    }
    rows.add(row);
}
br.close();