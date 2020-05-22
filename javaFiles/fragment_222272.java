File directory = new File("c:\temp");
    File[] files = directory.listFiles();
    for (File thisClass : files) {
        Runtime runTime = Runtime.getRuntime();
        try {
            Process process = runTime.exec(thisClass.getName());
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }