JSch jSch = new JSch();
    Session session = jSch.getSession("new", "sdf.org");
    Properties config = new Properties();
    config.put("StrictHostKeyChecking", "no");
    session.setConfig(config);
    session.connect();
    Channel channel = session.openChannel("shell");

    Expect expect = new ExpectBuilder()
            .withOutput(channel.getOutputStream())
            .withInputs(channel.getInputStream(), channel.getExtInputStream())
            .withEchoOutput(adapt(System.out))
    //        .withInputFilters(removeColors(), removeNonPrintable())
            .withErrorOnTimeout(true)
            .build();
    // try-with-resources is omitted for simplicity
    channel.connect();
    expect.expect(contains("[RETURN]"));
    expect.sendLine();
    String ipAddress = expect.expect(regexp("Trying (.*)\\.\\.\\.")).group(1);
    System.out.println("Captured IP: " + ipAddress);
    expect.expect(contains("login:"));
    expect.sendLine("new");
    expect.expect(contains("(Y/N)"));
    expect.send("N");
    expect.expect(regexp(": $"));
    // finally is omitted
    channel.disconnect();
    session.disconnect();
    expect.close();