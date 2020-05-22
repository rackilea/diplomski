$link = mysql_connect("sql306.byethost33.com", "b33_19513012", "loool");//change server name  //pass username according your settings
mysql_select_db("b33_19513012_pfe", $link);// also chang the Mysql database name
$sql1 = mysql_query("select * from admins WHERE username ='" . $_GET['username'] . "' and password='" . $_GET['password'] . "'", $link); //querstirng

if (!$sql1) {
    echo "Could not successfully run query ($sql) from DB: " . mysql_error($link);
    exit;
}

while ($row = mysql_fetch_assoc($sql1)) {
    $output[] = $row;
}
print(json_encode($output));// this will print the output in json

mysql_close($link);