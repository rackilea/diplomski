JSch shell = new JSch();
    session = shell.getSession(userName, serverIP, 22);  
    session.setPassword(password);

        session.setTimeout(timeout);
        java.util.Properties config = new java.util.Properties();
        config.put("StrictHostKeyChecking", "no");
        session.setConfig(config);
        session.connect();      

        channel = session.openChannel("shell");  
        input = new InputStreamReader(channel.getInputStream(), encoding);  
        output = new PrintStream(channel.getOutputStream());  

        channel.connect(); 

            output.write ("/home/test/runCommand");

            // result
            while ((ch = input.read () != -1) {....}