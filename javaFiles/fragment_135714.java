@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface MyJsonSubtype
{
   public String jsonTypeName();
}