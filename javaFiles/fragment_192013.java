exp(double b, int c) {
    if (c < 0)
        throw new Exception("C cannot be negative");
    } else if (c % 2 == 0) {
        return exp(b*b, c / 2);
    } else {
        /* and so forth */
    }
}