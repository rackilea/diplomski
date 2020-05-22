public static void main(String[] args){
    try{
        ServerSocket serverSocket = new ServerSocket(PORT);
        Socket socket = serverSocket.accept();
        PrintWriter printWriter = new PrintWriter(socket.getOutputStream());
        printWriter.write("Hello user!\n");
        printWriter.flush();
        printWriter.close();
        socket.close();
        serverSocket.close();
    }catch(IOException e){}
}