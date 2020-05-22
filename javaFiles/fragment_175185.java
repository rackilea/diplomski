public List<String[]> readData() throws IOException { 
    int count = 0;
    String file = "bank-Detail.txt";
    List<String[]> content = new ArrayList<>();
    try(BufferedReader br = new BufferedReader(new FileReader(file))) {
        String line = "";
        while ((line = br.readLine()) != null) {
            content.add(line.split(","));
        }
    } catch (FileNotFoundException e) {
      //Some error logging
    }
    return content;
}