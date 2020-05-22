public boolean equals(Object other) {
    if (other instanceof BigInteger) {
        return toString().equals(other.toString()) && sign == ((BigInteger) other).sign;
    }
    return false;
}