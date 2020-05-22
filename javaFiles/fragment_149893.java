int length = dest.remaining();

    // workaround: UsbRequest.queue always writes at position 0 :/
    ByteBuffer tmp = ByteBuffer.wrap(dest.array(), dest.position(), length);
    if(!inRequest.queue(tmp, length)) {
        throw new IOException("Error queueing request.");
    }

    UsbRequest request = deviceConnection.requestWait();
    if (request == inRequest) {
        dest.position(dest.position() + tmp.position());
        return tmp.position();
    }

    throw new IOException("requestWait failed! Request: " + request);