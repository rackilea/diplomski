Database db = new Database();

ResultSet resSet = db.executeQuery("SELECT * FROM table");

while (resSet.next()) {
  hashMap.put(resSet.getInt("Key"), resSet.getString("Value"));
}

resSet.close();
db.closeConnection();