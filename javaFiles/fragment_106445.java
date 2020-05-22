serverSocket = new ServerSocket(5963);
while(true) {
    final Socket socket = serverSocket.accept();
    new Thread(() -> {
        try {
            Writer out = new OutputStreamWriter(socket.getOutputStream());
            for (int i = 0; i < 10; i++) {
                int valor = (int) (Math.random() * 5) + 1;
                out.write("Você acabou de ganhar R$ "+new DecimalFormat("###,##0.00").format(valor)+"!");
                out.write("\r\n");
                out.flush();
                Thread.sleep(valor*1000);
            }
            socket.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }).start();
}