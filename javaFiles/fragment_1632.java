BufferedReader br = new BufferedReader(new FileReader(new File(
        "test.txt")));
String line = null, line2 = null;
HashMap<Integer, String> db = new HashMap<Integer, String>();
while ((line = br.readLine()) != null && !line.isEmpty()) {
    line2 = br.readLine();
    if (line2.isEmpty())
        continue;
    int id = Integer.parseInt(line.split(":")[1]);
    String name = line2.split(":")[1];
    db.put(id, name);
}