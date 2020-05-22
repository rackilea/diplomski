public static void main(String[] args) throws IOException 
{
    // reads in bytes from a file (args[0]) into input stream (inFile)
    FileInputStream inFile = new FileInputStream(args[0]);
    // creates an output stream (outFile) to write bytes to.
    FileOutputStream outFile = new FileOutputStream(args[1]);

    // get the unique channel object of the input file
    FileChannel inChannel = inFile.getChannel();
    // get the unique channel object of the output file.
    FileChannel outChannel = outFile.getChannel();    

    /* create a new byte buffer and pre-allocate 1MB of space in memory
       and continue to read 1mb of data from the file into the buffer until 
       the entire file has been read. */
    for (ByteBuffer buffer = ByteBuffer.allocate(1024*1024); inChannel.read(buffer) !=  1; buffer.clear()) 
    {
       // set the starting position of the buffer to be the current position (1Mb of data in from the last position)
       buffer.flip();
       // write the data from the buffer into the output stream
       while (buffer.hasRemaining()) outChannel.write(buffer);
    }

    // close the file streams.
    inChannel.close();
    outChannel.close();     
}