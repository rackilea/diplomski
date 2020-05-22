Database db = new Database();

for (Entry<Integer, String> next : hashMap) {
  db.executeUpdate("INSERT INTO table (Key, Value) VALUES("+next.getKey()+",'"+next.getValue()+"');";
}
db.closeConnection();