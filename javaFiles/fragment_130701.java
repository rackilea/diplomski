a = (boolean x, boolean y) -> {
    if (x) {
        if (y) return ttout;
        else return tfout;
    } else {
        if (y) return ftout;
        else return ffout;
    }
}