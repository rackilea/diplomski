public class ArgumentWrapper<T> {

    private Argument<T> argument;

    public ArgumentImplementation(Class<T> type, String name, 
            T defaultValue, Set<T> allowedValues, 
            Comparable<T> lowerBound, Comparable<T> upperBound) {
        argument = new Argument<T>(type);
        argument.setName(name);
        argument.setDefaultValue(defaultValue);
        argument.setAllowedValues(allowedValues);
        argument.setLowerBound(lowerBound);
        argument.setUpperBound(upperBound);
    }

    // some getters...

}