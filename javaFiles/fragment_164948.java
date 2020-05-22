$service_port = 12111;
$address = "127.0.0.1";

$socket = socket_create(AF_INET, SOCK_STREAM, SOL_TCP);
if ($socket === false) {
    print "Java Server Is down, or firewall protected";
    exit 1;
}

$result = socket_connect($socket, $address, $service_port);
if ($socket === false) {
    print "fatal error, (details)" . socket_strerror(socket_last_error($socket));
    exit 2;
} 

# YOU SHOUL PROVIDE YOUR REQUEST DATA IN THIS VARIABLE
$in = "";
$out = '';

socket_write($socket, $in, strlen($in));
$out = socket_read($socket, 2048);
print "received data : " . $out;

socket_close($socket);