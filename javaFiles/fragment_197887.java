ServerLauncher serverLauncher = new ServerLauncher.Builder()
        .setMemberName("server1")
        .setServerPort(40404)
        **.set("start-locator", "address[port1]")**
        .build();
    serverLauncher.start();