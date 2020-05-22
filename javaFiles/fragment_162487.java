Openfire server = new Openfire();
    boolean isConnected = server.connect(username,password);
    if(isConnected) {
        // Stash the username and password
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);

        // Stop the progress bar
        loginCompleted = true;
        // ....