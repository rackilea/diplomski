String folderPath = System.getProperty("user.home") + System.getProperty("file.separator") + "MyFolder";
File folder = new File(folderPath);     

 if(!folder.exists())
 {
    folder.mkdirs();
 }

 File saveFile = new File(folderPath, "fileName.ext");