channel=session.openChannel("exec");
        ((ChannelExec)channel).setCommand("bash /tmp/temp.sh");
        channel.setInputStream(null);
        channel.setOutputStream(System.out);
        InputStream out = channel.getInputStream();
        channel.connect();          
        StringBuilder outputBuffer = new StringBuilder();
        byte[] tmp = new byte[1024];

        while (true) {
            while (out.available() > 0) {
                int i = out.read(tmp, 0, 1024);
                if (i < 0)
                    break;
                outputBuffer.append(new String(tmp, 0, i));
            }
            if (channel.isEOF()) {
                break;
            }
        }
        System.out.println(" console output::::::::::: "+ outputBuffer.toString());
        System.out.println("Channel exit-status: " + channel.getExitStatus());
        channel.disconnect();