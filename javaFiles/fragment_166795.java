FileInputStream is = null;
    FileOutputStream fo = null;
    FileChannel inputChannel = null;
    FileChannel outputChannel = null;
    File bfile = new File(directoryPath + "/icons/" + outputFileName);
    try {
        is = FileLocator.openStream(Activator.getDefault().getBundle(), new Path("/images/" + imgFileName), false);
        inputChannel = is.getChannel();
        fo = new FileOutputStream(bfile);
        outputChannel = fo.getChannel();
        outputChannel.transferFrom(inputChannel, 0, inputChannel.size());
    } finally {
        // close everything in finally
    }