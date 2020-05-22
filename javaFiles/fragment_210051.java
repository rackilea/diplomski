import org.apache.commons.io.FileUtils;  // Add this import statement at the top


// Moved this statement outside the for loop, as it seems there is no need to fetch the archive directory path multiple times.
Path archiveDir = Paths.get(applicationContext.getEnvironment().getProperty("betl..archive.dir"));  

for(Path inputFile : pathsToProcess) {

    // Added this code
    if(checkIfFileMatches(inputFile, archiveDir); {
        // Add the logger here.
    }
    //Added the else condition, so that if the files do not match, only then you read, process in DB and move the file over to the archive. 
    else {
        // read in the file:
        readFile(inputFile.toAbsolutePath().toString());
        Files.move(inputFile, archiveDir.resolve(inputFile.getFileName()),StandardCopyOption.REPLACE_EXISTING);
    }       
}


//Added this method to check if the source file and the target file contents are same.
// This will need an import of the FileUtils class. You may change the approach to use any other utility file, or read the data byte by byte and compare. If the files are very large, probably better to use Buffered file reader.
    private boolean checkIfFileMatches(Path sourceFilePath, Path targetDirectoryPath) throws IOException {
        if (sourceFilePath != null) {  // may not need this check
            File sourceFile = sourceFilePath.toFile();
            String fileName = sourceFile.getName();

            File targetFile = new File(targetDirectoryPath + "/" + fileName);

            if (targetFile.exists()) {
                return FileUtils.contentEquals(sourceFile, targetFile);
            }
        }
        return false;
    }