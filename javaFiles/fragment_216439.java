@Configuration
@EnableMongoRepositories(...)
@Conditional(MongoClassPathCondition.class)
public class MongoAutoConfiguration {

    static class MongoClassPathCondition implements Condition {

        @Override
        public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
            return !ClassUtils.isPresent("javax.persistence.EntityManager", MongoAutoConfiguration.class.getClassLoader()); )//or whatever classpath element fits you best

        }
     }
}