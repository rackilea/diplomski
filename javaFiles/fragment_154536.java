public class Bicyle {
    // Notice we're declaring the variables outside the constructors, as fields.
    int gear;
    int cadence;
    int speed;

    public Bicycle() {
        // The variables are initialized (but not declared) here
        gear = 1;
        cadence = 10;
        speed = 0;
    }

    public someMethod() {
        //Accessing gear from outside constructor
        gear = gear + 1;
    }
}