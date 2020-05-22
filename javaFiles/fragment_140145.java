public class OfferException extends Exception{

   String message;

   public OfferException(String message){
        super(message); //call the super constructor
        this.message = message;   //Do you need it ?
   }
}