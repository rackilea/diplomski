Properties p = new Properties();
p.put("name", "Charles");
p.put("age", "45");
p.list(System.out); // new FileOutputStream("properties.txt")
// name=Charles
// age=45
p.load(new FileInputStream("properties.txt"));