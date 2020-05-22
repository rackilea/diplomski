//Write handshake response
    out.write("HTTP/1.1 101 Switching Protocols\r\n"
            + "Upgrade: websocket\r\n"
            + "Connection: Upgrade\r\n"
            + "Sec-WebSocket-Accept: " + hash + "\r\n"
            + "\r\n");
    out.flush();

    return true;