boolean isGreaterThan(MyObject<T> that) {
    return this.compareTo(that) > 0;
}

boolean isLessThan(MyObject<T> that) {
    return this.compareTo(that) < 0;
}