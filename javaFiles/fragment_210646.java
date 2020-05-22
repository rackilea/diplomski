<?php
$input = file_get_contents('php://input');
logToFile("post.txt",$input);

function logToFile($filename,$msg)
{
      $fd=fopen($filename,"a");
      $str="[".date("Y/m/d h:i:s")."]".$msg;
      fwrite($fd,$str."\n");
      fclose($fd);
}
?>