public class RedisManager {
...
public void connect() {
    if(pool != null) {
        System.out.println("Already exists");
        return;
    }
    JedisPoolConfig poolConfig = new JedisPoolConfig();
    ...