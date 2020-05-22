public boolean authenticate(String email, char[] password) {
   Table table = DatabaseBuilder.open(new File("C:/Users/Ameer Izwan/Documents/User_Details.accdb")).getTable("Login");
   Row row = CursorBuilder.findRow(table, 
            Collections.singletonMap("Email Address", email));
   if(row != null) {
     String p = row.get('Password');
   // if the password matches authenticate or else deny
   } else {
   // Dont authenticate
   }
}