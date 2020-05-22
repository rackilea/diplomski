try {
    if (requestSocket != null) { // this will be null if your server is offline when you tried to connect
        in.close();
        out.close();
        requestSocket.close();
    }
} // other stuff