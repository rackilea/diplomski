@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface MyTestCondition {

        public enum Condition {
                COND1, COND2
        }

        Condition condition() default Condition.COND1;
}