List<String> clmnList=null;
  List<Map<String,Object>> valList=new ArrayList<Map<String,Object>>();
  connection =  DriverManager.getConnection(connURL,userName,password);
  Statement stmt = connection.createStatement();
  ResultSet rs = stmt.executeQuery("select * from employee em left join department dept em.deptid=dept.id");

if(rs!=null)
{
    ResultSetMetaData rsmd = rs.getMetaData();
    int countColumn=rsmd.getColumnCount();

    for(int k=1;k<=countColumn;k++)
    {
        String name = rsmd.getColumnName(k);
        if(clmnList!=null && clmnList.size()>0){
            if(clmnList.contains(name)){
                name=rsmd.getTableName(k)+"."+name;
            }
            clmnList.add(name);
        }else{
            clmnList=new ArrayList<String>();
            clmnList.add(name);
        }
    }
    while (rs.next()) {
    Map<String,Object> valueMap=new HashMap<String, Object>();
    for(int i123=1;i123<=countColumn;i123++){
        valueMap.put(clmnList.get(i123-1),rs.getString(i123));
    }
    valList.add(valueMap);
    }
}