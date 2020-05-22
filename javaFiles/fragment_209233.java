my_arr.set(0,anyElement);


Statement stmt = null;
ResultSet query_rs;
String query = "SELECT * FROM my_table";
query_rs = stmt.executeQuery(query);
int counter_rs = 0;
ArrayList my_arr = new ArrayList();
while(query_rs.next())
{
  //here I want to add one row data in array index    
  my_arr.set(counter_rs,query_rs); //use this
  // or
  //  my_arr.add(query_rs);
  counter_rs++; 

}

//System.out.println(my_arr.toString()); //Show all data
// use for loop to get all data