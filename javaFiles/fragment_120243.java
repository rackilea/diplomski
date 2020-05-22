@Retention(RUNTIME)
@Target(FIELD)
public @interface Range {
    public int min() default Integer.MIN_VALUE;
    public int max() default Integer.MAX_VALUE;
}

@Retention(RUNTIME)
@Target(FIELD)
public @interface RegExp {
    public String value() default "^.*$";
}

@Retention(RUNTIME)
@Target(FIELD)
public @interface Required {

}