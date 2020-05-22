while(true){
        Socket sk = sok.accept();
        in = sk.getInputStream();
        out = sk.getOutputStream();
    Dr    byte[] buffer = new byte[1024];
        in.read(buffer);
        String recievedData = new String(buffer);
        System.out.println(recievedData);
        out.write(recievedData.getBytes());