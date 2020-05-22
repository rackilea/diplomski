ResultSet rs = statement.executeQuery();

// Repeat until there are no more result sets
for (;;) {

  // Empty the current result set
  while (rs.next()) {
    // [ .. do something with it .. ]
  }

  // Get the next result set, if available
  if (statement.getMoreResults()) {
    rs = statement.getResultSet();
  }
  else {
    break;
  }
}

// Be sure that all result sets are closed
statement.getMoreResults(Statement.CLOSE_ALL_RESULTS);
statement.close();