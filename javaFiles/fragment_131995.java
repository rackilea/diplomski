for(int index1=0;index1<5;index1++)
{   
    String tt="INSERT INTO   timetable(col1,col2,col3,col4,col5) VALUES(?,?,?,?,?);";
    stmt=con.prepareStatement(tt);
    stmt1.setInt(index1+1,index1*index2);
}