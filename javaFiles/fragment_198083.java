$address = 'minecraft.kayoticgamer.com';
$port = 9005;

$socket = socket_create(AF_INET, SOCK_STREAM, getprotobyname('tcp'));
socket_connect($socket, $address, $port);

$message .= chr(10);

$status = socket_sendto($socket, $message, strlen($message), MSG_EOF, $address, $port);
if($status !== FALSE)
{
    $message = '';
    $next = '';
    while ($next = socket_read($socket, 4096))
    {
        $message .= $next;
    }

    echo $message;
}
else
{
    echo "Failed";
}

socket_close($socket);