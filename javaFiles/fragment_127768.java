@GraphQLDirective(locations = OBJECT)
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface Key {
    public String[] fields;
}