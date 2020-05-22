@Retention(RetentionPolicy.RUNTIME) 
@Target ({ElementType.FIELD, ElementType.METHOD })
@Inherited
public @interface RestletResourceVariable {
    String name(); 
}