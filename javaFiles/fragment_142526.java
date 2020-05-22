try {
     rs = connection.createStatement().executeQuery(query);
     newConnection.shutdown(); // why shut down the connection when you plan to work on rs?
     rs.close(); // same question applies here
     return rs;
 }