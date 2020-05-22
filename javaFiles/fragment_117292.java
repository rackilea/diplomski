SSHClient ssh = new SSHClient();
    ...
    ssh.connect("sdf.org");
    ssh.authPassword("new", "");
    Session session = ssh.startSession();
    session.allocateDefaultPTY();
    Shell shell = session.startShell();
    Expect expect = new ExpectBuilder()
            .withOutput(shell.getOutputStream())
            .withInputs(shell.getInputStream(), shell.getErrorStream())
            .build();
    try {
        expect.expect(contains("[RETURN]"));
        expect.sendLine();
        String ipAddress = expect.expect(regexp("Trying (.*)\\.\\.\\.")).group(1);
        System.out.println("Captured IP: " + ipAddress);
        expect.expect(contains("login:"));
        expect.sendLine("new");
        expect.expect(contains("(Y/N)"));
        expect.send("N");
        expect.expect(regexp(": $"));
        expect.send("\b");
        expect.expect(regexp("\\(y\\/n\\)"));
        expect.sendLine("y");
        expect.expect(contains("Would you like to sign the guestbook?"));
        expect.send("n");
        expect.expect(contains("[RETURN]"));
        expect.sendLine();
    } finally {
        session.close();
        ssh.close();
        expect.close();
    }