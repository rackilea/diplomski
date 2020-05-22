public static String[] getSignature() throws IOException {
    String content = "";
    String appDataPath =System.getenv("APPDATA") + "\\Microsoft\\Signatures\\";
    System.out.println(appDataPath);
    File folder = new File(appDataPath);
    File[] listOfFiles = folder.listFiles();  

    String imagePath ="";
    for (int i = 0; i < listOfFiles.length; i++) {
        File file = listOfFiles[i];
        if (file.isFile() && file.getName().endsWith(".htm")) {
            content = FileUtils.readFileToString(file, "windows-1252");
            content = content.replaceAll("src=\"", "src=\"" + appDataPath.replace("\\", "/"));   

        }else if(file.isDirectory()){
            File[] listOfHtmlFiles = file.listFiles();
            for (File f : listOfHtmlFiles) { 
                if(Files.probeContentType(f.toPath()).contains("image")) {
                      imagePath = f.getPath();
                }
            }
        }
    }

    return new String[]{content,imagePath};
}