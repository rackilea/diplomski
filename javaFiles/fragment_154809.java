LogEvent event = null;
private Socket socket1 = null;
private ServerSocket ss = null;
PrintWriter sspw=null;
ObjectInputStream objectInputStream = null;
try {
        //Creating Socket and making it listen to a specific port, receiving through streams.
        //Servers socket creation and waiting
        ss = new ServerSocket(9000);
        socket1 = ss.accept();

        objectInputStream = new ObjectInputStream(new BufferedInputStream(socket1.getInputStream()));

        while (true) {  
            event = (LogEvent) objectInputStream.readObject();
            System.out.println(event.getLoggerName());
            System.out.println(event.getLevel());
            System.out.println(event.getMessage().getFormattedMessage());
        }
} catch (Exception e) {
    e.printStackTrace();
} finally {
    if (objectInputStream != null) {
        objectInputStream.close();
    }
}