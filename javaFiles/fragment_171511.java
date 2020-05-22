URL url = new URL("http://www.google.com/");
        URLConnection connection;
        connection = url.openConnection();
        InputStream in = connection.getInputStream();        
        BufferedReader bf = new BufferedReader(new InputStreamReader(in));
        StringBuffer html = new StringBuffer();

        char[] charBuffer = new char[4096];
        int count=0;

        do {
            count=bf.read(charBuffer, 0, 4096);
            if (count>=0) html.append(charBuffer,0,count);
        } while (count>0);
        bf.close();