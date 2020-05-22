class Primitive_int {
    int val;

    // "++value"
    int prefixIncrement() {
        val = val + 1;
        return val;
    }

    // "value++"
    int postfixIncrement() {
        int old = val;
        val = val + 1;
        return old;
    }
}