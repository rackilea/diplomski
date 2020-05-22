SshTerminal term = new SshTerminal(host, username, password);

    term.waitFor("$ ");
    term.send("su -");
    term.waitFor("Password: ");
    term.send(rootPassword);
    term.waitFor("# ");
    term.send("ls /root");
    term.waitFor("# ");
    term.send("cat /file-not-found 2>&1");
    term.waitFor("# ");

    term.send("cat /var/log/messages");
    term.waitFor("# ");
    String logFileContent = term.getLastResponse();

    term.send("exit");
    term.waitFor("$ ");
    term.send("exit");

    term.disconnect();

    String[] lines = logFileContent.split("\n");
    for (int i = 0; i < lines.length; i++)
        logger.info("Line {} out of {}: {}", i + 1, lines.length, lines[i]);