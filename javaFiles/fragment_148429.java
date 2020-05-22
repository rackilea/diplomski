@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Target({ElementType.FIELD, ElementType.METHOD, ElementType.ANNOTATION_TYPE})
@Replace(expression = "`", replacement = "")
@Parsed
public @interface MyReplacement {

@Copy(to = Parsed.class)
String field() default "";

@Copy(to = Parsed.class, property = "index")
int myIndex() default -1;