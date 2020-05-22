import org.springframework.cache.annotation.Cacheable;

@Cacheable(value = "skills", key = "#root.methodName")
public List<Skill> getAllSkills() {
    return ... your skills ...;
}