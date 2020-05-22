int i=1; 
while (resultSet.next()) {
if(i==1)
{String s1=resultSet.getString("Court_Num");
System.out.println(a1+"="+s1);}
if(i==2)
{String s1=resultSet.getString("Court_Num");
System.out.println(a2+"="+s1);}
if(i==3)
{String s1=resultSet.getString("Court_Num");
System.out.println(a3+"="+s1);}
i++