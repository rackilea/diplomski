@RequestScoped
@Stereotype
@Retention(RetentionPolicy.RUNTIME)
@Alternative
@Target({
    ElementType.TYPE, ElementType.METHOD
})
public @interface Staging {}