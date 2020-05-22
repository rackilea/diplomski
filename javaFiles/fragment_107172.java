String _01 = "HTTP/1.1 101 Switching Protocols\r"; // Added \r here.
String _02 = "Upgrade: websocket\r"; // Added \r here.
String _03 = "Connection: Upgrade\r"; // Added \r here.
String _04 = "Sec-WebSocket-Accept: " + responseKey + "\r"; // Added \r here.
String _05 = "Sec-WebSocket-Protocol: chat\r"; // Added \r here.
String _06 = "Content-Encoding: identity\r"; // Added \r here.