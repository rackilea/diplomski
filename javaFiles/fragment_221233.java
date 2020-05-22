public class RollMyFile {

    private long FILE_MAX_SIZE;
    private String fileName;

    /**
     * Constructor to take in the initial file name and the maxFileSize
     * @param fileNameToStartWith
     */
    public RollMyFile(String fileNameToStartWith, long maxFileSize) {
        this.fileName = fileNameToStartWith;
        this.FILE_MAX_SIZE = maxFileSize;
    }

    /**
     * Synchronized to roll over to a new file
     * 
     * @param fileChannel
     * @return
     * @throws IOException
     */
    public synchronized AsynchronousFileChannel rollMeIfNeeded(AsynchronousFileChannel fileChannel) throws IOException {
        if(fileChannel.size()>FILE_MAX_SIZE) {
            this.fileName = getNewRolledFileName(this.fileName);
            File file = new File(this.fileName);
            file.createNewFile();
            fileChannel = getAsyncChannel(this.fileName);
        }
        return fileChannel;
    }

    /**
     * Change this to create a new name for the roll over file
     * @param currentFileName
     * @return
     */
    public String getNewRolledFileName(String currentFileName) {
        if (currentFileName.contains(".")) {
            currentFileName = currentFileName.substring(0,
                    currentFileName.lastIndexOf('.'));
        }
        return currentFileName+ "." + Calendar.getInstance().getTimeInMillis();
    }

    /**
     * This is where you request to write a whole bunch of stuff that
     * you said you want to store
     * 
     * @param stuffToWrite
     * @throws IOException
     */
    public void write(StringBuffer stuffToWrite) throws IOException {
        AsynchronousFileChannel fileChannel = getAsyncChannel(this.fileName);
        fileChannel = rollMeIfNeeded(fileChannel);
        ByteBuffer byteBuffer = ByteBuffer.wrap(stuffToWrite.toString().getBytes());
        fileChannel.write(byteBuffer, fileChannel.size());
    }

    /**
     * Change this to how ever you 'open' the AsynchronousFileChannel
     * 
     * @param givenFileName
     * @return
     * @throws IOException
     */
    private AsynchronousFileChannel getAsyncChannel(String givenFileName) throws IOException {
        return AsynchronousFileChannel.open(Paths.get(givenFileName), StandardOpenOption.WRITE);
    }

}