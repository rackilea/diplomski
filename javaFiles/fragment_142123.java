public class MaxGramsOfCheeseValidator implements ConstraintValidator<MaxGramsOfCheese, Integer> {

    @Autowired
    private Environment env;

    private int max;

    public void initialize(MaxGramsOfCheese constraintAnnotation) {
        this.max = Integer.valueOf(env.resolvePlaceholders(constraintAnnotation.max()));
    }

    @Override
    public boolean isValid(Integer value, ConstraintValidatorContext context) {
        return value != null && value <= this.max;
    }

}