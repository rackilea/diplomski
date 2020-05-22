public class DuplicatingTimeBasedRollingPolicy<E> extends TimeBasedRollingPolicy<E> {
    // root directory of log (so we can retain subdirectory structures in copy)
    String originalRoot;
    // root directory for secondary log location
    String duplicateRoot;

    @Override
    Future<?> asyncCompress(String nameOfFile2Compress,
            String nameOfCompressedFile, String innerEntryName)
            throws RolloverFailure {
        // Do standard async compression
        final Future<?> future = super.asyncCompress(nameOfFile2Compress, nameOfCompressedFile,
                innerEntryName);

        // Figure out the file name to copy to and from
        String extension = compressionMode == CompressionMode.ZIP ? ".zip" : ".gz";
        final String sourceFileName = nameOfCompressedFile + extension;
        final String destFileName = duplicateRoot + File.separator + sourceFileName.substring(originalRoot.length());

        new Thread(new Runnable() {

            @Override
            public void run() {
                try {
                    // Wait for compression to finish and then make a copy
                    future.get();
                    FileUtils.copyFile(new File(sourceFileName), new File(destFileName));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();

        return future;
    }
}