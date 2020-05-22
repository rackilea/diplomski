Database db = DatabaseBuilder.open(new File(
        "C:/Users/Gord/Desktop/Database1.accdb"));
Table table = db.getTable("People");
Map<String, Object> criteria = new HashMap<String, Object>();
criteria.put("FirstName", "Jimmy");
criteria.put("LastName", "Hoffa");
Row row = CursorBuilder.findRow(table, criteria);
if (row == null) {
    System.out.println("No row found that matches all criteria.");
}
else {
    System.out.println(String.format("Row found: ID=%d.", row.get("ID")));
}