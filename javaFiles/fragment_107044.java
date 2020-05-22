public static String downloadPath = "/My-Folder-Name";
File fileDir = new File(downloadPath);

if (fileDir.isDirectory()) {
        request.setDestinationInExternalPublicDir(downloadPath, filename);
    } else {
        fileDir.mkdirs();
        request.setDestinationInExternalPublicDir(downloadPath, filename);
    }