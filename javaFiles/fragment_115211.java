public float division(int x, int y) {
    if (y != 0) {
        return ((float) x) / y;
    }
    else {
        throw new IllegalArgumentException("division by 0 makes no sense");
    }
}