ArrayList<String>  list  =  new ArrayList<String>();
  list.add("boy");
  list.add("girl");
  Class.forName("com.mysql.jdbc.Driver");
  Connection con = DriverManager.getConnection("url", "root", "");
  Statement st = con.createStatement();
  StringBuilder sb = new StringBuilder("Select * from table where keyword IN (");
  boolean added = false;
  for(String s:list){
    if (added){
      sb.append(",");
    }      
    sb.append("'");
    sb.append(s);
    sb.append("'");
    added = true;
  }
  sb.append(")");
  ResultSet rs = st.executeQuery(sb.toString());