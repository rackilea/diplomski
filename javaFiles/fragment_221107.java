@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE})
@interface SortingFields {

    String[] fields();

}