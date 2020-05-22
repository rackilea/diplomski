@Pattern(regexp="[a-zA-Z]*")
@Size
@Constraint(validatedBy = AlphanumericStringValidator.class)
@Documented
@Target({ METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER })
@Retention(RUNTIME)
public @interface AlphanumericString {
   // ...
  @OverridesAttribute(constraint=Size.class, name="min")
  int min() default 3
  @OverridesAttribute(constraint=Size.class, name="max")
  int max() default 230;       
   // ...
}