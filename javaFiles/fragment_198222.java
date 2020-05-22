new Thread(new Runnable(){
    public void run(){
        TCPServer tcpserver = null;
        try {
            tcpserver = new TCPServer(8888);             
        }
        catch (IOException e){
            e.printStackTrace(System.err);
        }
        tcpserver.waitForConnections();  
    }
}).start();

new Thread(new Runnable(){
    public void run(){
        UDPServer udpserver = null;
        try {
            udpserver = new UDPServer(8889);
        }
        catch (IOException e){
            e.printStackTrace(System.err);
        }
        udpserver.waitForConnections();
    }
}).start();