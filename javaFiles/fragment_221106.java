@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD})
@interface FieldExtractor {

    String getterName();

}