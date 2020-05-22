public class Foo {
    //my fields go here...
    //getters for each field go here as well...

    //now this method will be ignored for Jackson JSON serialization
    @JsonIgnore
    public String getIdentifier() {
        //fancy code that returns an identifier
    }
}