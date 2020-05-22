String filepath = "";

    URL url = Platform.getBundle(MyPLugin.PLUGIN_ID).getEntry("lib/dummy.exe");

    try {
        filepath = FileLocator.toFileURL(url).toString();
    } catch (IOException e1) {
        // TODO Auto-generated catch block
        e1.printStackTrace();
    }

    System.out.println(filepath);