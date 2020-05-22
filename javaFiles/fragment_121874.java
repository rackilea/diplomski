Socket client = new Socket(serverIp, port);
        OutputStream out = client.getOutputStream();
        InputStream in = client.getInputStream();

        String test = "REQUEST-STRING**";
        out.write(test.getBytes());
        out.flush();

        int c;
        while ((c=in.read())!=-1) {
            if (isEndOfResponse(c)) {
                break;
            }
            System.out.print((char)c);
        }
        client.close();