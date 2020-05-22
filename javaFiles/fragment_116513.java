@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Component
@Scope("prototype")
public @interface ScheduledJob {
    String cronExpression() default "";
    long fixedRate() default -1;
    boolean durable() default false;
    boolean shouldRecover() default true;
    String name() default "";
    String group() default "";
}