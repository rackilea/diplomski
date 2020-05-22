Socket conn = new Socket(server, 80);
        //Request made here
        InputStream is = conn.getInputStream();

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        byte[] buffer = new byte[1024];
        int readBytes = -1;

        while((readBytes = is.read(buffer)) > 1){
            baos.write(buffer,0,readBytes);
        }

        byte[] responseArray = baos.toByteArray();