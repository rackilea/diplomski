String osver = System.getProperty("os.name");
        String app;
        if (osver.contains("Mac")){
            app = "wd" + "/relap5.x\"";
        } else if (osver.contains("Windows")){
            app = "relap5.exe";
        } else if (osver.contains("linux")) {
            app = "/relap5.x";
        }
        System.out.println(app);