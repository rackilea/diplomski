boolean filefound = false;
File getFileInFolder(File folder, String fileName) {
    filefound = false;
    //System.out.println(" PathTo : "+folder.getAbsolutePath());
    File [] files = folder.listFiles();
    File file = null;
    if (files != null) {

        for (int i = 0; i < files.length; i++) {
            if (files[i].isDirectory()) {
                file = getFileInFolder(files[i],fileName);
                if(filefound) {
                    file= files[i];
                    break;
                }
            } else {
                //System.out.println(" file : "+files[i].getName());
                if (files[i].getName().equals(fileName)) {
                    System.out.println(" Found file : "+files[i].getName());
                    file= files[i];
                    filefound = true;
                    break;
                }
            }
        }   
    }

    return file;
}