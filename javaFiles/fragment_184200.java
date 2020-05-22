public void configure(JobConf job) {
    // Get the cached archives/files
    Path[] localFiles = DistributedCache.getLocalCacheFiles(job);

    // open, read and store for use in the map phase.
}