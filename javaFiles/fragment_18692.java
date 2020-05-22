import javax.validation.ConstraintViolationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation 
.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalControllerExceptionHandler extends 
ResponseEntityExceptionHandler {

private static final Logger LOGGER = 
LoggerFactory.getLogger(GlobalControllerExceptionHandler.class);

////////////  Globle exception handler  ///////////
@ExceptionHandler(Exception.class)
public ResponseEntity handleAnyException(final Exception e,final WebRequest 
request) {
    LOGGER.error("Error occurred while processing request: {}", 
e.getMessage());
    e.printStackTrace();
    ResponseDTO responseDTO = new ResponseDTO();
    responseDTO.setSuccess(false);
    responseDTO.setCode(500);
    responseDTO.setMessage(e.getMessage());
    return new ResponseEntity<>(responseDTO, 
HttpStatus.INTERNAL_SERVER_ERROR);
}

////////////Self define exception class handler  ///////////

@ExceptionHandler(InvalidCredentialException.class)
public ResponseEntity handleInvalidCredentialException(final 
InvalidCredentialException e,final WebRequest request) {
    LOGGER.error("Invalid Credential: "+ e.getCause());
    ResponseDTO responseDTO = new ResponseDTO();
    responseDTO.setSuccess(false);
    responseDTO.setCode(e.getErrorCode());
    responseDTO.setMessage(e.getMessage());
    return new ResponseEntity<>(responseDTO, HttpStatus.UNAUTHORIZED);
}}