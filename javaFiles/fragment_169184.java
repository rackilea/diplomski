public void copyFile(){

    Path workingCopy = null;

    //Create a plain text file called example-file-error.txt, add some text to the file, and save it in user.home
    Path path = Paths.get(System.getProperty("user.home"), "example-file-error.txt");

    try{
        workingCopy = Files.createTempFile(path.getParent(), "temp", ".txt");

        //Create a locked file, but the lock is actually created by a separate program
        FileChannel fileChannel = FileChannel.open(path, StandardOpenOption.READ);
        FileLock lock = fileChannel.lock(0, Long.MAX_VALUE, true);

        //This line seems to be the solution to the problem
        Files.move(workingCopy, path, StandardCopyOption.REPLACE_EXISTING, StandardCopyOption.ATOMIC_MOVE);

    }catch(IOException ex){
        ex.printStackTrace();
    }finally{
        try{
            Files.deleteIfExists(workingCopy);
        }catch(IOException ex){
            ex.printStackTrace();
        }

    }

}