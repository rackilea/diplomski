public Stack<File> getFilesInFolder(String startPath) {
    File startFolder = new File(startPath);
    Stack<File> picturestack = new Stack<File>();

    String extension;
    int dotindex;

    // Go through the folder
    for (File file : startFolder.listFiles()) {
        extension = "";
        dotindex = file.getName().lastIndexOf('.'); // Get the index of the dot in the filename

        if (dotindex > 0) {
            extension = file.getName().substring(dotindex + 1);

            // Iterate all valid file types and check it
            for (String filetype : validpicturetypes) {
                if (extension.equals(filetype)) {
                    picturestack.add(file);
                }
            }
        }
    }
    return picturestack;
}