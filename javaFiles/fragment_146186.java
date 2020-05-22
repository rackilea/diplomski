for (T s : testSub) {
    if (s instanceof Class1) {
        assertEquals(((Class1) s).getSource(), "TEST"));
    } else if (s instanceof Class2) {
        assertEquals(((Class2) s).getSource(), "TEST"));
    } else {
        throw new IllegalArgumentException();
    }
}