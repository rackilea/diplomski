public class Error implements Serializable {
     private String message;
     public Error() {
     }
     public Error(String message) {
          this.message = message;
     }
     public String getMessage() {
          return message;
     } 
     public void setMessage(String message) {
          this.message = message ;
     } 
 }

 import com.yourproject.models.Error;
 @RestController
 class DoubleController {
   ..... 
 }