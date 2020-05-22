void doSomethingImportant(String name) {
  if (!isAlphaNumeric(name)) { throw new IllegalArgumentException(); }
  Object o = lookupThingy(name);
  // No chance of SQL-Injection because name is alpha-numeric.
  connection.executeStatement("INSERT INTO MyTable (column) VALUES ('" + name + "')");
}