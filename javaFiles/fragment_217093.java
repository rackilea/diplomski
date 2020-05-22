public class ComplexObjectOptional {

    Optional<String> theTitle;  
    Optional<List<Optional<String>>> stringArray;
    Optional<BasicObjectOptional> theObject;

    public ComplexObjectOptional() {
    }

    public ComplexObjectOptional(boolean initialize) {
        if (initialize) {
            theTitle = Optional.ofNullable("Complex Object");   
            stringArray =    Optional.ofNullable(Arrays.asList(Optional.ofNullable("Hello"),Optional.ofNullable("World")));
            theObject = Optional.ofNullable(new BasicObjectOptional(true));
        }
    }

    @Override
    public String toString() {
        return String.format("theTitle = %s, stringArray = %s, theObject = (%s)", theTitle, stringArray, theObject);
    }   
}