public class IntegerNumber implements AnyNumber {

    public IntegerNumber add(AnyNumber other) {  // NOTE: Must be AnyNumber!!
        IntegerNumber otherInteger = (IntegerNumber)other;
            // will throw a ClassCastException at runtime if "other" is, say, RealNumber
        ...
    }
}