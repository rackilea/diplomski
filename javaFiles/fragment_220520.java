getWeeklyOpenPositions(boolean flagCurrently){
String query="SELECT * FROM Report WHERE Open_TS BETWEEN '20160101' AND '20161230'";

if(flagCurrently)
{
 query=query+ " AND close_TS>NOW()";
} 
}