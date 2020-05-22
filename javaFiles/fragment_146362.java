public class Home {

    private float squareFootage;

    public abstract void validateSquareFootage() throws MyValidationException; // you could throw an exception, runtime exception or return a boolean to indicate if value is valid or not

    public void setSquareFootage(float squareFootage) {
        validateSquareFootage(squareFootage); // again, throws exception or returns boolean, up to you
        this.squareFootage = squareFootage;
    }

    // ... rest of implementation
}