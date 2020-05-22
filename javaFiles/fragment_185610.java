public Map<String, String> getdatafromdatabase()
{
 String query1="Select * from imposm3";
        Statement mystmt = connection.createStatement();
         ResultSet myRrs = mystmt.executeQuery(query1);
  Map<String, String> details= new HashMap<String, String>();
         while (myRrs.next()) {
  details.put("id", myRrs.getString("id"));
  details.put("tags", myRrs.getString("tags"));
  details.put("geom",myRrs.getString("geom"));
          }
return details;
}