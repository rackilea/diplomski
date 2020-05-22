//this is our class within the library. We cant edit its source
class APIClass {
    private int privatefield;
    protected int protectedfield;

    public String doStuff() { ... }
    public int doMoreStuff() { ... }
}

class MyExtendedAPIClass extends APIClass {
    // you dont have to override doStuff and doMoreStuff

    void setValues() {
        protectedfield = 10; //compiles, protectedfield is protected
        privatefield = 1; //does not compile, privatefield is private
    }
}