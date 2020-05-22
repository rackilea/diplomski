try {
  conn = DriverManager.getConnection(url, username, password);
  reachable = TestDB(conn);
} catch (Exception e) {
   reachable = false;
}