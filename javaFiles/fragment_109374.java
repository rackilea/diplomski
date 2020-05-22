public class State {

    /**
     * This is the constructor 
    */
    public State(String value1, String value2){
        this.value1 = value1;
        this.value2 = value2;
    }

    // Omiting getters/setters for brevety.
    // This will be set by the constructor using the values that it
    // receives as arguments 
    // e.g
    // new State("My Val1","My Val2");
    private String value1;
    private String value2;
}