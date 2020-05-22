$tokenResult = mysql_query("SELECT reg_ids FROM table_with_regids"); //
$i = 0;
while($row = mysql_fetch_array($tokenResult)) {

     $registrationIDs[$i] = $row['reg_ids'];
     $i++;
}