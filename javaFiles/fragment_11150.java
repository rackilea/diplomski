public void setup(Context context) {
    Configuration conf = context.getConfiguration();
    Path[] cachedFiles = DistributedCache.getLocalCacheFiles(conf);
    File metadataFile = new File(chachedFiles[0].toString());

    // metadataFile can now be read and the results stored locally for use in the map method
}