mysql_connect("localhost","root","");

mysql_select_db("androidapp");

$fname = mysql_real_escape_string($_POST['fname']);

$result = mysql_query("SELECT surname FROM names WHERE fname = '$fname'");

//if you want only one record then
$row = mysql_fetch_array($result);

echo json_encode($row);

mysql_close();