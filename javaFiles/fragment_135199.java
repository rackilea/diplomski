private ArrayList getNegativeNumbers(ResultSet rs, String coulumnName ) throws SQLException
  { 
    ArrayList ret = new ArrayList();
    while(rs.next()){
      try {
        int x = rs.getInt(coulumnName);
        if(x>=0){
          ret.add(new Integer(x));
        }
      } catch (Exception ex) {
          String x = rs.getString(coulumnName);
          ret.add(x);
      } 
    }
    return ret;
  }