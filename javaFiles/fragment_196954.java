// Trad anonymous inner class
// Operands: o1 and o2. Return value: int
Comparator<String> cTrad = new Comparator<String>() {
    @Override
    public int compare(final String o1, final String o2) {
        return o1.compareToIgnoreCase(o2);
    }
};

// Lambda-style
// Operands: o1 and o2. Return value: int
Comparator<String> cLambda = (o1, o2) -> o1.compareToIgnoreCase(o2);

// Method-reference à la bullet #2 above. 
// The invokation can be translated to the two operands and the return value of type int. 
// The first operand is the string instance, the second operand is the method-parameter to
// to the method compareToIgnoreCase and the return value is obviously an int. This means that it
// can be translated to "instanceRef::methodName".
Comparator<String> cMethodRef = String::compareToIgnoreCase;