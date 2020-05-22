CountingInputStream inputStream;
Long totalContentLength;

private int getProgressPercentage(){
    Long processedBytes = this.inputStream.getByteCount();
    if (0 < totalContentLength && processedBytes <= totalContentLength) {
        int percent = (int) ((processedBytes * 100.0 / totalContentLength));
        LOGGER.info("Processed bytes: {}, Total bytes: {}, Progress: {}%", processedBytes, totalContentLength, percent);
        return percent;
    }
    return 0;
}