String where = "";
if (name != null) {
    where = " AND name = ?";
}
if (age != null) {
    where += " AND age = ?";
}
if (gender != null) {
        where += " AND gender = ?";
}
String sqlStatement = "SELECT * FROM Tablename";
if (where.length() > 0) {
    sqlStatement += " WHERE " + where.substring(5);
}