http_response_code(200);  
$file = 'D:\\'.$destination;
$fp = fopen($file, 'r');
//ob_end_clean();  
header('Content-Description: File Transfer');
header('Content-Type: application/octet-stream'); 
//header("Cache-control: private");
//header('Pragma: private');
//header("Expires: Mon, 26 Jul 1997 05:00:00 GMT");
header('Content-Length: ' . filesize($file));

$buffer = 1024*8;
while(!feof($fp)) {

echo fread($fp, $buffer);
ob_flush();
flush();



}
fclose($fp);
exit();