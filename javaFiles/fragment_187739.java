List<String> allowedNames = Arrays.asList<String>("FName", ..);

// Ensures the name is valid, or throws an Exception;
// it could also return a normalized name or a boolean, but an
// Exception is the quickest way to ensure "fail fast".
private void assertSearchableColumn(string colName) {
    if (!allowedNames.contains(colName)) {
        throw new RuntimeException("Invalid column");
    }
}

// Then before a particular column is replaced in the SQL command, but there
// is no need to have function that merely sets the global variable.
String col = search_fields.getSelectedItem().toString();
assertSearchableColumn(col);

// Only replace columns, note that the columns are *not* quoted as strings
// in the resulting SQL, and that ? represents "a placeholder".
String sql = String.format("select %s from stud where %s like ?", col, col);

// And then bind the SQL with the appropriate value to use with LIKE.
// (I have no idea what "DB" is or how/if it supports placeholders, however..
//  but if it does not already, it *should* support placeholders
//  or else it is too easy for SQL Injection, accidental or otherwise.)