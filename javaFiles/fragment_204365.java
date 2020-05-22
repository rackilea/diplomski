if (s1NameNumPair[0].compareTo(s2NameNumPair[0]) > 0) {
    return 1;
} else if (s1NameNumPair[0].compareTo(s2NameNumPair[0]) < 0) {
    return -1;
} else {
    Double n1 = Double.parseDouble(s1NameNumPair[1]);
    Double n2 = Double.parseDouble(s2NameNumPair[1]);
    return n1.compareTo(n2);
}