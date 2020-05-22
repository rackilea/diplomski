socket.setSoTimeout(1000L);
boolean continueSending = true;
int counter = 0;
while (continueSending && counter < 10) {
    // send to server omitted
    counter++;
    try {
        socket.receive(packet);
        continueSending = false; // a packet has been received : stop sending
    }
    catch (SocketTimeoutException e) {
        // no response received after 1 second. continue sending
    }
}