HashMap[] h = foo.getHashMapArray();
h[0] = new PrinterStateReasons();

// ... elsewhere, in some `Foo` class -- perhaps compiled
// completely separately from the code above, perhaps
// even by a completely different team and even a different
// compiler --  and only combined with the code above at runtime...

public HashMap[] getHashMapArray() {
    return new LinkedHashMap[4];
}