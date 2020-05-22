/**
 * Does something with s.
 * @param s The input string
 */
public void badlyDesignedMethod(String s) {
    // Here the programmer omitted to check s against null
    int i = s.length();
    ...
}

/**
 * Does something with s.
 * @param s The input string; must not be null
 */
public void betterDesignedMethod(String s) {
    if (s == null) {
        throw new IllegalArgumentException("The parameter s must not be null!);
    }
    int i = s.length();
    ...
}

public void caller() {
    badlyDesignedMethod(null); // will throw NullPointerException
    // It is the fault of the programmer of badlyDesignedMethod()
    // as they have not specified that the parameter must not be null.

    betterDesignedMethod(null); // will throw IllegalArgumentException
    // Now it is the fault of the programmer of caller()
    // as they violated the contract of betterDesignedMethod()
    // which DOES tell them that the parameter must not be null
}