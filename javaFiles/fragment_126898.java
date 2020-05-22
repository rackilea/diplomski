private void copyOrMoveFile(File file, File dir,boolean isCopy) throws IOException {
    File newFile = new File(dir, file.getName());
    FileChannel outChannel = null;
    FileChannel inputChannel = null;
    try {
        outChannel = new FileOutputStream(newFile).getChannel();
        inputChannel = new FileInputStream(file).getChannel();
        inputChannel.transferTo(0, inputChannel.size(), outChannel);
        inputChannel.close();
        if(!isCopy)
        file.delete();
    } finally {
        if (inputChannel != null) inputChannel.close();
        if (outputChannel != null) outputChannel.close();
    }
}