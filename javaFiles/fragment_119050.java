if (val1 == null) {
    return val2 == null;
}
else {
    return val2 != null && val1.compareTo(val2) == 0;
}