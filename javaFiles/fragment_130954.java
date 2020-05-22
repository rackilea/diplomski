String osver = System.getProperty("os.name");
    String app;
    if (osver.equals("Mac")){
        app = "wd" + "/relap5.x\"";
    } else if (osver.equals("Windows")){
        app = "relap5.exe";
    } else if (osver.equals("linux")) {
        app = "/relap5.x";
    }
    System.out.println(app);