@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Import({MyInterfaceScanRegistrar.class})
public @interface MyInterfaceScan {

  String[] value() default {};
}