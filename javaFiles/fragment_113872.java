this is the page you want people to go on:
 $times = time(); 
 $num = $times + 10000;
mysql_connect("localhost", "dbname", "password") or
die("Could not connect: " . mysql_error());
mysql_select_db("dbname");
$result = mysql_query("SELECT  FROM $tablename WHERE areloggedin > $num);
$num=mysql_numrows($result);
if( $num < 0 ){
header('Location: http://redirectpage.html');