public static void main(String[] args) {

    EchoServer clientEchoServer = new EchoServer(), \
               managerEchoServer = new EchoServer();

    managerEchoServer.start();
    managerEchoServer.echo("HI!");

    Thread manager = new Thread(managerEchoServer, "manager");
    manger.start();


    clientEchoServer.start();
    clientEchoServer.echo("HI!");

    Thread client = new Thread(managerEchoServer, "manager");
    client.start();

}