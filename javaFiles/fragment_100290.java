@ResponseStatus(HttpStatus.NOT_FOUND)
public class ResourceNotFoundException  extends RuntimeException{
    private static final long serialVersionUID = 1L;
    public ResourceNotFoundException(String message) {
        super(message);
    }

}

@Controller
@RequestMapping("/XXXXXs")
public class DoctypesController {
    @RequestMapping( method = RequestMethod.GET , value="/xxx")
    public  ResponseEntity<?> getXXXXXX(HttpServletRequest request) {
         if (XXX == null ) {
               throw new ResourceNotFoundException("XXXX Not found for);
           }else{
            response = buildResponse(xxxx)
           }

         return response;
    }
}


@ControllerAdvice
public class XXXXEntityExceptionHandler extends ResponseEntityExceptionHandler {

@ExceptionHandler(value = { ResourceNotFoundException.class })
protected ResponseEntity<Object> handleMissingResource(RuntimeException ex, final WebRequest request) {
HttpStatus status = HttpStatus.NOT_FOUND;
    return new ResponseEntity<Object>(new Error(String.valueOf(status.value()), status.getReasonPhrase(),ex.getMessage()),status);
    }
}