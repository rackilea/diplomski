Connection conn = null;
try {
    conn = DriverManager.getConnection(sCon);
}
catch (Exception e) {
    System.out.println("Connect failed : " + e.getMessage());
    throw new Exception("Halted.");
}