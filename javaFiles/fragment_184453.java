@ControllerAdvice
public class ExceptionController {

    NumberFormat numberFormatter = new DecimalFormat("#0.00");

    @ExceptionHandler(value = Exception.class)
    public ResponseEntity<?> handleException(Exception e) { 
        if(e instanceof MultipartException){
            String message = "Invalid form data";
            if(e.getCause() instanceof IllegalStateException){
                if(((MultipartException) e).getRootCause() instanceof SizeException){
                    SizeException sizeException = (SizeException) ((MultipartException) e).getRootCause();
                    if(sizeException instanceof FileSizeLimitExceededException){
                        FileSizeLimitExceededException cause = (FileSizeLimitExceededException) sizeException;
                        message  = "File Size should be less than: " + numberFormatter.format(cause.getPermittedSize()/Math.pow(2F, 20)) + "MB";
                    }
                    else if(sizeException instanceof SizeLimitExceededException){
                        SizeLimitExceededException cause = (SizeLimitExceededException) sizeException;
                        message  = "Request Size should be less than: " + numberFormatter.format(cause.getPermittedSize()/Math.pow(2F, 20)) + "MB";
                    }
                }
            }
            return new ResponseEntity<YourCustomResponseObject>(new 
            YourCustomResponseObject(message), 
            HttpStatus.ANY_ERROR_CODE_YOU_WANT);
             }
        }
}