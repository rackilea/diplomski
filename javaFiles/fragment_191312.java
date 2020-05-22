@Data
@ToString
@Component
@ConfigurationProperties(prefix = "my.application")
public class JobConfig {
    List<Job> job;
}

@Data
class Job {
    private String name;
    private String group;
    private String clazz;
}