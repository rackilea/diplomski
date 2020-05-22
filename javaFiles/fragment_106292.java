// Get array with all files of `Tango`
File[] allFiles = f1.listFiles();

for (File file : allFiles) {
    // extract the extension John1.txt > John1
    String filename = file.getName().substring(0, file.getName().indexOf("."));
    // get the the new folder
    File newDir = new File(filename);

    // create the folder if not exists (delete this if you dont want to make new dir)
    if (!newDir.exists()) {
        newDir.mkDir();
    }

    // and rename it to the new folder + name
    file.renameTo(new File(newDir.getAbsolutePath() + File.separator + file.getName()));

}