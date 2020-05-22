BufferedReader br = new BufferedReader(new FileReader(new File("C:/sample/sample.txt")));
String line;
while ((line = br.readLine()) != null) {
   // process the line.
}
br.close();