FileWriter fw = null;
Map<String, FileWriter> map = new HashMap<>();
while (data.hasNextLine()) {
    String line = data.nextLine();
    String[] split = line.split("\t");
    String filename = "D:\\P&G\\March Sample Data\\" + split[0] + " "
            + split[1] + ".txt";
    // System.out.println((filename));
    // System.out.println(line);
    if (map.containsKey(filename)) {
        fw = map.get(filename);
    } else {
        fw = new FileWriter(filename, true);
        map.put(filename, fw);
    }
    // ...
}
for (FileWriter file : map.values()) {
    file.close();
}