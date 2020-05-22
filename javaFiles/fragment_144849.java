Object o = q.take();
if (o instanceof X) {
    X x = (X) o;
    // do work with x
} else if (o instanceof Y) {
    Y y = (Y) o;
    // do work with y
} else {
    // o is neither X nor Y
}