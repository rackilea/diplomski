ArrayList<Account> accounts = new ArrayList<Account>();
try {
    StringBuilder sb = new StringBuilder();
    BufferedReader br = new BufferedReader(new FileReader("C:\\readFile.txt"));
    String line;
    while ((line = br.readLine()) != null) {
        accounts.Add(new Account(line));
    } 
} catch (FileNotFoundException e) {
  e.printStackTrace();
} catch (IOException e) {
  e.printStackTrace();
} finally {
  if (br != null) {
    try {
      br.close();
    } catch (Exception ex) {
      e.printStackTrace();
    }
  }
}