if (a.equals(b)) {
    return 0;
} else if (a.size() > b.size()) {
    return 1;
} else if (b.size() > a.size()) {
    return -1;
} else {
    return System.identityHashCode(a) > System.identityHashCode(b) ? 1 : -1;
}