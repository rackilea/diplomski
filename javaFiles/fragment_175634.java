int i = 0;
while(rs.next()){
    // int i = 0;
    last_updatedArr[i] = rs.getString("Last_updated");
    System.out.println(last_updatedArr[i]);
    i++;
}

SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
java.sql.Date date1,date2;
// reuse i from while loop...
for(i = 0; i < last_updatedArr.length; i++){