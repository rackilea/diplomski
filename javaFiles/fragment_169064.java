List<MyBean> lt = new ArrayList<MyBean>(); 
while(rs.next()) 
{
    MyBean obj = new MyBean(); 

    //Set your recodrs using setter method.
    obj.setSystem_name(rs.getString("system_name"));
    obj.setArrival_time(rs.getString("arrival_time"));

    lt.add(obj);
}
//Return your list to JSP side