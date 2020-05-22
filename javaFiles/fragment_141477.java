public static String getSignature() throws IOException {
    String content ="";
    String appDataPath = System.getenv("APPDATA")+"\\Microsoft\\Signatures\\"; 
    System.out.println(appDataPath);
    File folder = new File(appDataPath);
    File[] listOfFiles = folder.listFiles();

    for (int i = 0; i < listOfFiles.length; i++) {
      File file = listOfFiles[i];

      if (file.isFile() && file.getName().endsWith(".htm")) {
            content = FileUtils.readFileToString(file , "windows-1252");
            content =content.replaceAll("src=\"", "src=\"" +appDataPath.replace("\\", "/"));
      } 
    } 

    return  content; 
}