File baseDirectory = applicationContext.getFilesDir();
File file = new File( baseDirectory, "settings.data" );
if (file.exists()) {
    //We have to convert it to newsettings.Data
    byte[] convertedBytes = common.utils.SerializeTools.changePathInSerializedFile(file, "old.path.data", "new.path.data");

    //Write converted file
    File newFile = new File( baseDirectory, "newsettings.data" );
    FileOutputStream fos = new FileOutputStream(newFile);
    fos.write(convertedBytes);
    fos.close();

    //Remove old file
    file.delete();
}