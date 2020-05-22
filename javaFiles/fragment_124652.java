Statement stmt = con.createStatement(
                                  ResultSet.TYPE_SCROLL_INSENSITIVE,
                                  ResultSet.CONCUR_UPDATABLE);
   ResultSet rs = stmt.executeQuery("SELECT a, b FROM TABLE2");
   // rs will be scrollable, will not show changes made by others,
   // and will be updatable