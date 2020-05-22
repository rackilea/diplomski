try {
  BufferedReader br = new BufferedReader(new FileReader(new File("yourFile.txt")));
  String line;
  while ((line = br.readLine()) != null) {
    System.out.println(line);
  }
  br.close();
} catch (IOException e) {
  e.printStackTrace();
}