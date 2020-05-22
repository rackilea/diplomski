@ControllerAdvice
    public class GlobalExceptionHandlers {

        private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandlers.class);


        /***************** User Defined Exceptions *************************/

        @ExceptionHandler({ EmployeePartnerNotFoundException.class })
        public ResponseEntity<Object> handleEmployeePartnerNotFoundException(EmployeePartnerNotFoundException ex) {

        logger.error("EmployeePartnerNotFoundException : ", ex);

        ErrorResponse errorResponse = new ErrorResponse("500", ex.getMessage());

        return new ResponseEntity<Object>(errorResponse, new HttpHeaders(), HttpStatus.BAD_REQUEST);
        }

        // other exception handlers

}