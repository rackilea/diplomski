String request = "CONNECT google.com:443 HTTP/1.1";
String authority = request.split(" ")[0];
String[] tokens = request.split(":");
String host = tokens[0];
int port = (tokens.length == 2)? Integer.parseInt(tokens[1]) : 443;
InetSocketAddress address = InetSocketAddress(host, port);