List<Integer> integerList = new ArrayList<Integer>();

List<Number> numberList = integerList; // compiler error, prevents:
numberList.add(new Double(3.14)); // would insert a Double into integerList

Collection<Integer> integerCollection = integerList; // allowed
// OK because List extends Collection and the <type parameter> did not change

Collection<Number> numberCollection = integerList; // compiler error
// an "Integer" is a "Number"
// but "a collection of Integers" is more specific than "a collection of Numbers"
// and cannot be generally treated the same way and guarantee correct behavior

List<?> rawList = integerList; // allowed, but...
rawList.add(new Integer(42));  // compiler error, Integer is not a ... a what?