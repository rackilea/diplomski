/**
 * MySqlCallMultipleResultSet.java
 * Copyright (c) 2007 by Dr. Herong Yang. All rights reserved.
 */
import java.sql.*;
public class MySqlCallMultipleResultSet {
  public static void main(String [] args) {
    Connection con = null;
    try {
      com.mysql.jdbc.jdbc2.optional.MysqlDataSource ds 
        = new com.mysql.jdbc.jdbc2.optional.MysqlDataSource();
      ds.setServerName("localhost");
      ds.setPortNumber(3306);
      ds.setDatabaseName("HerongDB");
      ds.setUser("Herong");
      ds.setPassword("TopSecret");
      con = ds.getConnection();

// Create CallableStatement
      CallableStatement cs = con.prepareCall("CALL HeadTail(?)");

// Register OUT parameters
      cs.registerOutParameter(1, java.sql.Types.INTEGER);     

// Execute the CALL statement and expecting multiple result sets
      boolean isResultSet = cs.execute();

// First ReulstSet object
      if (!isResultSet) {
        System.out.println("The first result is not a ResultSet.");
        return;
      }

// First ReulstSet object
      System.out.println("Head of the table:");
      ResultSet res = cs.getResultSet();
      while (res.next()) {
        System.out.println("  "+res.getInt("ID")
          +", "+res.getString("FirstName")
          +", "+res.getString("LastName")
          +", "+res.getTimestamp("ModTime"));

      }
      res.close();

// Move to the next result
      isResultSet = cs.getMoreResults();
      if (!isResultSet) {
        System.out.println("The next result is not a ResultSet.");
        return;
      }

// Second ReulstSet object
      System.out.println("Tail of the table:");
      res = cs.getResultSet();
      while (res.next()) {
        System.out.println("  "+res.getInt("ID")
          +", "+res.getString("FirstName")
          +", "+res.getString("LastName")
          +", "+res.getTimestamp("ModTime"));

      }
      res.close();

// Retrieve OUT parameters
      System.out.println("Total number of records: "+cs.getInt(1));

// Close resource
      cs.close();

      con.close();
    } catch (Exception e) {
      System.err.println("Exception: "+e.getMessage());
      e.printStackTrace();
    }
  }
}