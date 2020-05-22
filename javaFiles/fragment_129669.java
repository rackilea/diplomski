//client side        
        Socket sendChannel=new Socket("localhost", 12345);
        OutputStream writer=sendChannel.getOutputStream();
        writer.write(new byte[]{1});
        writer.flush();

        InputStream reader=sendChannel.getInputStream();
        byte array[]=new byte[1];
        int i=reader.read(array);

//server side
        ServerSocket s=new ServerSocket(12345);
        Socket receiveChannel = s.accept();

        OutputStream writerServer=receiveChannel.getOutputStream();
        writer.write(new byte[]{1});
        writer.flush();

        InputStream readerServer=receiveChannel.getInputStream();
        byte array2[]=new byte[1];
        int i2=reader.read(array);