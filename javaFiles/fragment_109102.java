//get all files into a single array
File[] allFiles = getAListOfAllFilesRecursively("rootFolder");

//sort the files by their path (File is Comparable)
Arrays.sort(allFiles);

for (int x = 0; x < allFiles.length(); x++) {
    //if x ends with .srt, rename x+1 (the .mp4) based on the name we parse from x
    //otherwise, rename x (the .mp4) based on the name we parse from x+1
    if (allFiles[x].getName().endsWith(".srt")) {
        String name = getNameFromFileName(allFiles[x].getName());
        renameFileToName(allFiles[x+1], name);
    } else {
        String name = getNameFromFileName(allFiles[x+1].getName());
        renameFileToName(allFiles[x], name);
    }
}