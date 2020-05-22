String tt="INSERT INTO   timetable(col1,col2,col3,col4,col5) VALUES(?,?,?,?,?);";
stmt1=con.prepareStatement(tt);

for(int index1=0;index1<5;index1++)
{   
    stmt1.setInt(index1+1,index1*index2);
}