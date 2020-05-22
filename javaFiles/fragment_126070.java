<?php
// mysql connection, etc....
$query  = "SELECT * FROM Tips";
$result = mysql_query($query);
$output = array();
while($row = mysql_fetch_array($result))
    $output[]=$row;

print(json_encode($output));
mysql_close($con);