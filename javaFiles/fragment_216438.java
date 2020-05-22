@Configuration
@EnableJpaRepositories(basePackages=...)
@Conditional(JpaClassPathCondition.class)
public class JpaAutoConfiguration {

    static class JpaClassPathCondition implements Condition {

        @Override
        public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
            return ClassUtils.isPresent("javax.persistence.EntityManager", JpaAutoConfiguration.class.getClassLoader());
        }
     }
}