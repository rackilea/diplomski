sql="SELECT DISTINCT CONVERT(VARCHAR(10), Intensity.Date, 103) AS MyDate FROM Intensity";
ResultSet r=sta.executeQuery(sql);
String json="";
json=json+"{'data':[";
while(r.next()){
    json=json+"'"+r.getString("MyDate")+"',";
}