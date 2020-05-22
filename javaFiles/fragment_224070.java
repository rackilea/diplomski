@Aspect
@Component
public class GlobalExceptionRestAOPController {


    private ObjectMapper objectMapper = new ObjectMapper();

    @Around("execution(org.springframework.http.ResponseEntity com.springapp.mvc..*(..))")
    public Object manageException(ProceedingJoinPoint pjp) throws Throwable{
        Object result;
        try{
            result = pjp.proceed();
        } catch (Exception e){
            // log it.
                       result = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).contentType(MediaType.APPLICATION_JSON).body(objectMapper.writeValueAsString(new ExceptionReport(e.toString())));

        }

        return result;
    }
}

class ExceptionReport{
    private final String error;

    public ExceptionReport(String error) {
        this.error = error;
    }

    public String getError() {
        return error;
    }
}