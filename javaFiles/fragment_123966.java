try {
    // Create channel on the source
    FileChannel srcChannel = new FileInputStream("srcFilename").getChannel();

    // Create channel on the destination
    FileChannel dstChannel = new FileOutputStream("dstFilename").getChannel();

    // Copy file contents from source to destination
    dstChannel.transferFrom(srcChannel, 0, srcChannel.size());

    // Close the channels
    srcChannel.close();
    dstChannel.close();
} catch (IOException e) {
}