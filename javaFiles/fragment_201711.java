@Configuration
class RedisConfig {
    @Bean
    fun getRedisConnection(
        @Value("\${redis.host}") host: String,
        @Value("\${redis.port}") port: String) = RedisClient.create(RedisURI.create("redis://$host:$port")).connect()
}

@Service
class RedisService(private val connection: StatefulRedisConnection<String?,String?>) {
    private val log = LoggerFactory.getLogger(this::class.java)

    fun useConnection() {
        // use connection here
    }
}