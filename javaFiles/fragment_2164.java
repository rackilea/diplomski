@Plugin(ConstraintValidator.class)
public class ResourceValidator implements ConstraintValidator<ValidResource, String>{


    private static final Logger log = Logger.getLogger(ResourceValidator.class);

    @Inject
    private MyConfiguration conf;

    @Override
    public void initialize(ValidResource constraintAnnotation) {
        // nothing to do here
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if(value == null) {
            return true;
        }
        String fullPath = conf.getBasePath() + File.separator + value;
        return new File(fullPath).exists();
    }

}