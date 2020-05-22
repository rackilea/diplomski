BufferedReader reader = new BufferedReader(new FileReader(STATIC_DB_NAME));
String line  = reader.readLine();
while(line != null){
  db.execSQL(line); 
  line = reader.readLine();
}
reader.close();