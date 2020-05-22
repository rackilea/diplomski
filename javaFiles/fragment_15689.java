Socket sk = sok.accept();
        in = sk.getInputStream();
        out = sk.getOutputStream();
        byte[] buffer = new byte[1024];
    while(true){
        int nread = in.read(buffer);
        String recievedData = new String(buffer, 0, nread);
        System.out.println(recievedData);
        out.write(recievedData.getBytes());