// Start a new session
    session = sshClient.startSession();
    session.allocatePTY("vt220", 80,24,0,0,Collections.<PTYMode, Integer>emptyMap());

    Command cmd = null;
    String response = null;
    // your allocating a new session there
    try (Session session = sshClient.startSession()) {

         cmd = session.exec("sudo service riak start");
         response = IOUtils.readFully(cmd.getInputStream()).toString();
         cmd.join(timeout, timeUnit);
    } finally {
        if (cmd != null) 
            cmd.close();
    }