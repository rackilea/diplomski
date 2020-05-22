File sourcePath = new File("/path/to/be/backed/up");
File destPath = new File("X:/BackupHere");

// Get all the files from sourcePath
List<File> listFiles = getFilesFrom(sourcePath);

for (File toBackup : listFiles) {

    // Now we need to strip off the sourcePath
    // Get the name of the file
    String fileName = toBackup.getName();
    // Get parent folder's path
    String path = toBackup.getParent();
    // Remove the source path from file path
    path = path.substring(sourcePath.getPath().length());

    // Append the file name to the path
    path = path + File.separator + fileName;

    // Now we have the name of the back up file
    String backupFile = destPath + path;

    System.out.println("Backup to " + backupFile);

}