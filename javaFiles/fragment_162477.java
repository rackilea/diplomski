File[] subFiles = file.listFiles();

// Create the list
List<JxploreFile> subFolders = new ArrayList<>();

// Add all the sub folders (note that "file" is a bit magic since it 
// is not specified anywhere in the original post
for (File subFile : file.listFiles()) {
    if (subFile.isDirectory()) {
        subFolders.add(new JxploreFile(subFile));
    }
}

// Return an array
return subFolders.toArray(new JxploreFile[subFolders.size()]);