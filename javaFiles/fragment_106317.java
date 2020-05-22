while(true) 
{

    //listens for connection
    Socket connected = Server.accept();

    //prints clients adddress and port
    System.out.println( " THE CLIENT"+" "+ connected.getInetAddress() +":"+connected.getPort()+" IS CONNECTED ");

    Random rannum = new Random();
    int num = rannum.nextInt(12);

    String random = Integer.toString(num);

    System.out.println("Turning on Button " + num);

    PrintWriter outToClient = new PrintWriter(connected.getOutputStream(),true);
    outToClient.println(random);
}