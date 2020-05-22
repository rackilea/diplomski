List<string> avaMaxTempList = new List<string>();
while (rs.next()) 
{
    for ( int i=1, y=0; i<numOfCols+1; i++,y++ ) 
{
    out.print("<td>" + rs.getString(i) + "</td>");
        avMaxTemp += rs.getString(i) +",";
    }
avaMaxTempList.Add(avaMaxTemp);
}