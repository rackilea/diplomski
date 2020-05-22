try{
    File file = new File("randomfile.txt");
    FileChannel channel = new RandomAccessFile(file, "rw").getChannel();
    FileLock lock = channel.lock();//Obtain a lock on the file
    try{

        //Do your things

    }
    finally{
        lock.release();//Release the lock on the file
        channel.close();
    }

} 
catch (IOException e) {
   e.printStackTrace();
}