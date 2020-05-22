long lastID = -1;

// repeat the rest of the code until the result is empty
selectStatement.setLong(1, lastID);
selectStatement.setInt(2, 100000);

ResultSet result = selectStatement.executeQuery();
while (result.next()) {
 Long id = result.getLong(1);
 lastID = id;
 // do stuff ...
}