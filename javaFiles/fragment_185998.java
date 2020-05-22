public static JSONObject getObject(String query){
   try (Connection con = getConnect()) {
       Statement stmt = con.createStatement();
       ResultSet rs = stmt.executeQuery(query);
       ...
   }
}