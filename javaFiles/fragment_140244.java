@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.ANNOTATION_TYPE)
public @interface DependsOn {
    Class<? extends Annotation>[] value();

    /**
     * Specifies whether all dependencies are required (default),
     * or any one of them suffices
     */
    boolean all() default true;
}