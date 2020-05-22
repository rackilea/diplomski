/**
 * compares this object with another object for equality.
 * A DecimalBigInt is equal to another object only if this other
 * object is also a DecimalBigInt and both represent the same
 * natural number.
 */
public boolean equals(Object o) {
    return o instanceof DecimalBigInt &&
        this.compareTo((DecimalBigInt)o) == 0;
}