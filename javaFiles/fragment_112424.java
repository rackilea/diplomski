public static void main(args) {
  Connection con = DriverManager.getConnection("jdbc:mysql://localhost/database","username","password");
  FileReader file = new FileReader("SomeGiantFile.csv");
  Scanner scan = new Scanner(file);
  scan.useDelimiter(",");
  String token;
  while ( scan.hasNext() ) {
    token = scan.next();
    try {
      PreparedStatement ps = con.prepareStatement("Insert into TONS_OF_STRING (UNIQUE_STRING) values (?)");
      ps.setString(1, token);
      ps.executeUpdate();
    } catch (SQLException e) {
      System.out.println("Found duplicate: " + token );
    }
  }
  con.close();
  System.out.println("Well that was easy, I'm all done!");
  return 0;
}