ResultSet set = /* some sql query */;
String someField;
if (set.next()) {
    //gets the value of the column "my_field"
    someField = set.getString("my_field");
} else {
    //no results!
    someField = null;
}