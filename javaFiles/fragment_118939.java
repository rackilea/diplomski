<?php

$base=$_REQUEST['image'];
$name=$_REQUEST['name'];
echo $base;
// base64 encoded utf-8 string
$binary=base64_decode($base);
// binary, utf-8 bytes
header('Content-Type: bitmap; charset=utf-8');


$file = fopen(name, 'wb');
fwrite($file, $binary);
fclose($file);
echo '<img src='+name+'>';