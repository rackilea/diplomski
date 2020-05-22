try {
     //You code there
}
catch (SQLException e) {
  while (e != null) {
      System.out.println("\n Message: " + e.getMessage());
      System.out.println("\n SQLState: " + e.getSQLState());
      System.out.println("\n ErrorCode: " + e.getErrorCode());
      e = e.getNextException();
  }
}