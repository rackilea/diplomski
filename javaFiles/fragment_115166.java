// inject the actual template
@Autowired
private RedisTemplate<String, Integer> template; // This can be RedisTemplate<String, Long> also based on your need

// inject the template as ValueOperations
@Resource(name="redisTemplate")
private ValueOperations<String, Integer> valueOps;

public Integer decrement(String key) {
    return ((Long)valueOps.increment(key, -1l)).intValue();
}