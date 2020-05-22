@Target({ METHOD, FIELD, ANNOTATION_TYPE })
@Retention(RUNTIME)
@Documented
@Constraint(validatedBy = ValidMapValidator.class)
public @interface ValidMap {
   String message() default "valid.map";

   Class<?>[] groups() default {};

   Class<? extends Payload>[] payload() default {};
}

public class ValidMapValidator implements
      ConstraintValidator<ValidMap, Map<?, ?>> {

   @Override
   public void initialize(final ValidMap annotation) {
      return;
   }

   @Override
   public boolean isValid(final Map<?, ?> map,
         final ConstraintValidatorContext context) {
      if (map == null || map.size() == 0)
         return true;

      // Iterate each map entry and validate
      return true;
   }
}