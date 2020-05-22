ServerSocket serverSocket = null;
try {
    serverSocket = new ServerSocket(6644);
} catch (IOException e) {
    e.printStackTrace();
}
while(true){
    Socket clientSocket = serverSocket.accept();

}