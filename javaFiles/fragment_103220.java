$sock = socket_create(AF_INET, SOCK_STREAM, 0);
socket_connect($sock, $host, $port);

socket_write($sock, $str);

$response = '';
while($resp = socket_read($sock, 1024)) {
    if(!$resp)
        break;
    $response .= $resp;
    if(strpos($resp, "\n") !== false)
        break;
}

echo "Server said: {$response}";