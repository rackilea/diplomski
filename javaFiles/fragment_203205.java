while(countDownLatch.getCount() != 0) {
    try {
        socket = serverSocket.accept();
    } catch(SocketTimeoutException e) {
      //timeout occurred!
    }
}