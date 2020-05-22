import java.util.Map;

import javax.annotation.Resource;

import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.hash.HashMapper;
import org.springframework.data.redis.hash.ObjectHashMapper;

import foo.Person;

public class HashMapping {

@Resource(name = "redisTemplate")
private HashOperations<String, byte[], byte[]> hashOperations;

private HashMapper<Object, byte[], byte[]> mapper = new ObjectHashMapper();

public void writeHash(String key, Person person) {

    Map<byte[], byte[]> mappedHash = mapper.toHash(person);
    hashOperations.putAll(key, mappedHash);
}

public Person loadHash(String key) {

    Map<byte[], byte[]> loadedHash = hashOperations.entries(key);
    return (Person) mapper.fromHash(loadedHash);
}
}