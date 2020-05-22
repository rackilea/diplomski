String appdata= System.getenv("APPDATA");   

System.out.println(appdata);


String dataFolder = System.getProperty("user.home") + "\\Local Settings\\ApplicationData";

System.out.println(dataFolder);


String dataFolder2 = System.getenv("LOCALAPPDATA");