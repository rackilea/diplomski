@Aspect
@Component
public class ControllerResponseValidator {

    Logger logger = Logger.getLogger(ControllerResponseValidator.class);

    @Autowired
    private Validator validator;

    @AfterReturning(pointcut = "execution(* com.example.controller.*.*(..))", returning = "result")
    public void validateResponse(JoinPoint joinPoint, Object result) {
        validateResponse(result);
    }

    private void validateResponse(Object object) {

        Set<ConstraintViolation<Object>> validationResults = validator.validate(object);

        if (validationResults.size() > 0) {

            StringBuffer sb = new StringBuffer();

            for (ConstraintViolation<Object> error : validationResults) {
                sb.append(error.getPropertyPath()).append(" - ").append(error.getMessage()).append("\n");
            }

            String msg = sb.toString();
            logger.error(msg);
            throw new RestException(HttpStatus.INTERNAL_SERVER_ERROR, msg);
        }
    }
}