@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface DayOfWeek {

    public String[] names();

}