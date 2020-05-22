//Create the /lib directory with the .jars and the service.exe
    //The resource_path is the package where are your files...
    String resource_path = "br/com/myservice/resources/";
    Util.copyResource(this.getClass().getClassLoader(), resource_path, "PAF_Service.exe", currentDirectory);

    resource_path = resource_path + "lib/";
    String directory_lib = currentDirectory + "lib/";

    File dir_lib = new File(directory_lib);
    if(!dir_lib.exists()){
        dir_lib.mkdir();
    }

    Util.copyResource(this.getClass().getClassLoader(), resource_path, "ksoap2-android-assembly-2.6.5-jar-with-dependencies.jar", directory_lib);
    Util.copyResource(this.getClass().getClassLoader(), resource_path, "log4j-1.2.17.jar", directory_lib);
    Util.copyResource(this.getClass().getClassLoader(), resource_path, "WinRun4J.jar", directory_lib);