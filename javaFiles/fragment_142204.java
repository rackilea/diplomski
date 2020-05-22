Runtime run = Runtime.getRuntime();
    String lcOSName = System.getProperty("os.name").toLowerCase();
    boolean MAC_OS_X = lcOSName.startsWith("mac os x");
    if (MAC_OS_X) {
        run.exec("open " + file);
    } else {
        //run.exec("cmd.exe /c start " + file); //win NT, win2000
        run.exec("rundll32 url.dll, FileProtocolHandler " + path);
    }