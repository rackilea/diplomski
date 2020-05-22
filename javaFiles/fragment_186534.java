File file = new File("./db.txt");
BufferedReader br = new BufferedReader(new FileReader(file));
String line1 = br.readLine();
String line2 = br.readLine();
String line3 = br.readLine();
br.close();