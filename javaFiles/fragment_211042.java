public static void main(String[] args){
    try{
        ServerSocket serverSocket = new ServerSocket(12345);
        while(true){
            new Thread(new ClientConnectionThread(serverSocket.accept())).start();
        }
    }catch(IOException e){e.printStackTrace();}
}

private class ClientConnectionThread implements Runnable{
    private Socket socket;
    public ClientConnectionThread(Socket socket){
        this.socket = socket;
    }
    @Override
    public void run(){
        try{
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream());
            System.out.println("Client says " + in.readLine());
            out.write("HELO Back!\n"); //again, print("HELO Back!\n") and
                //println("HELO Back!") should also work
            out.flush();
            out.close();
            in.close();
            socket.close();
        }catch(IOException e){e.printStackTrace();}
    }
}