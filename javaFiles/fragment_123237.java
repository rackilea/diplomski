Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
ResultSet rs = stmt.executeQuery("SELECT * FROM table1");

Statement stmt2 = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
ResultSet rs2 = stmt2.executeQuery("SELECT * FROM table2");

rs.first(); // move to the first row (only row)
rs.updateInt(2, 50); // update our primary key, which is also the
                            // cascading fk 50 could be any number
System.out.println(rs.getString(2)); // Prints the old value 12
rs.updateRow();
System.out.println(rs.getString(2)); // Prints the new value 50

rs2.first();
rs2.refreshRow(); // make sure we get the latest data from table2
System.out.println(rs2.getString(2)); // Prints the new value 50