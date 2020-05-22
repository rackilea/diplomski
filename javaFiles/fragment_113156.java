public long digitProduct (long anInteger) throws Exception {
    if (anInteger <= 0) {
        throw new Exception ("digitProduct:  input integer " + anInteger +
            " is less than or equal to zero.");
    }
    long product = 1;
    do {
        product = product * (anInteger % 10);  // modulo 10 is last digit.
        anInteger = anInteger / 10;  // Shifts out last digit.
    } while (anInteger > 0);
    return product;
} // digitProduct (long)