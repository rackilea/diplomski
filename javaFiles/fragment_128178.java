val cloudWatchConfig = object : CloudWatchConfig {
    override fun get(key: String) = "my-service-metrics"
    override fun enabled() = true
    override fun step() = Duration.ofSeconds(30)
    override fun batchSize() = CloudWatchConfig.MAX_BATCH_SIZE
}