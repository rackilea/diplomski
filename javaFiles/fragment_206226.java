public void sendHttpRequest(byte[] requestData, Socket connection) {
    long startTime = System.nanoTime();
    writeYourRequestData(connection.getOutputStream(), requestData);
    byte[] responseData = readYourResponseData(connection.getInputStream());
    long elapsedTime = System.nanoTime() - startTime;
    System.out.println("Total elapsed http request/response time in nanoseconds: " + elapsedTime);
}