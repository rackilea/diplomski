long totalSpaceWindows(String path) throws IOException {
    path = FilenameUtils.normalize(path);
    if (path.length() > 2 && path.charAt(1) == ':') {
        path = path.substring(0, 2); // seems to make it work
    }

    // build and run the 'fsutil' command
    String[] cmdAttribs = new String[] {
            "cmd.exe",
            "/C",
            "fsutil volume diskfree " + path
                    + " | Find \"Total # of bytes\"" };

    // read in the output of the command to an ArrayList
    List lines = performCommand(cmdAttribs, Integer.MAX_VALUE);

    //because we used Find, we expect the first line to be "Total # of bytes",
    //you might want to add some checking to be sure
    if (lines.size() > 0) {
        String line = (String) lines.get(0);
        String bytes = line.split(":")[1].trim();
        return Long.parseLong(bytes);
    }
    // all lines are blank
    throw new IOException(
            "Command line 'fsutil volume diskfree' did not return 
                    + "any info  for path '" + path + "'");
}