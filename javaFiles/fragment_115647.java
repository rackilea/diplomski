final String nameOS = "os.name";  
    final String versionOS = "os.version";  
    final String architectureOS = "os.arch";
    System.out.println("\n  The information about OS");
    System.out.println("\nName of the OS: " + 
    System.getProperty(nameOS));
    System.out.println("Version of the OS: " + 
    System.getProperty(versionOS));
    System.out.println("Architecture of THe OS: " + 
    System.getProperty(architectureOS));