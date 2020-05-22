<?php
   $now = time(); 
   $db_unix = strtotime($res->theMysqlTimestamp);
   $datediff = $now - $db_unix;
   echo floor($datediff/(60*60*24));
?>