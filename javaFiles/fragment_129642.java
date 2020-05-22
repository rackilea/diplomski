Object o = new Object(); // extracted variable to improve visibility of new instance creation
Objects.requireNonNull(o);
    // this is the body of Objects.requireNonNull():
    if (o == null) {
    /*>*/throw new NullPointerException(); // this line is still part of  requireNonNull() body
    }
    return o;