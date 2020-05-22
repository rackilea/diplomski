public class Reservation {

   //Hide the constructor
   private Reservation() {
   }

   private Reservation(int code) {
       this.code = code;
   }

   //Use a factory method in the same class
   public static Reservation instance(int code) {
       Reservation r = new Reservation();
       r.code = code;

       return r;
   }

   //A builder class, which could also be declared externally
   public static class Builder {

       //optional parameter
       private int code;

       public Reservation getReservation() {
           return new Reservation(this.code());
       }

       //A "setter" enabling fluent API
       public Builder code(int code) {
           this.code = code;
           return this;
       }
   }
}