ServerSocket server = new ServerSocket(5494);
ServerSocket s1 = new ServerSocket(9898);
ServerSocket s2=new ServerSocket(9999);
while (true) {

            ScreenServer.client = server.accept();
            client1=s2.accept();//accept connection on port 9999
            client2=s1.accept();//accept connection on port 9898