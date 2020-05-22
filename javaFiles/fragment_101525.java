while(rs.next())  
{    

String a = rs.getString("enrollno");
String b = rs.getString("name");
JSONObject xyz = new JSONObject();
xyz.put("no" , a);
xyz.put("name" ,b); 

abc.put(xyz);
System.out.println(abc.toString());
}