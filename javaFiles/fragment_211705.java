public static String directoryMusicLocator(File dir) {
    try 
    {
        String[] filetype = new String[] { "mp3" }; // only search mp3 files
        StringBuilder outString = new StringBuilder("Getting all .mp3 files in " + dir.getCanonicalPath() + " including those in subdirectories\n");
        List<File> files = (List<File>) FileUtils.listFiles(dir, filetype, true);
        for (File file : files) 
        {
            outString.append(file.getAbsolutePath()+"\n"); // get the file's absolute path
        }
        outString.append("\nFinished Searching.");
        return outString.toString()
    }
    catch (IOException e) 
    {
        e.printStackTrace();
        return null;
    }
}

private void findMP3ButtonActionPerformed(java.awt.event.ActionEvent evt) {                                              
    // TODO add your handling code here:
    String fLocation = dirToSearch.getText(); // this gets the input from the textfield
    File dir = new File(fLocation); // converts the location to path
    String output = MusicSearch.directoryMusicLocator(dir); 

    // Replace <jTextArea> with your JTextArea field name
    <jTextArea>.setText(output);
}