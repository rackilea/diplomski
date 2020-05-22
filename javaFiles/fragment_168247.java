public boolean equals(Object x) {
    if(this == x)
        return true;
    if(x == null)
        return false;
    if(!(x instanceof Number))
        return false;
    Number n = (Number)x;
    return (n.doubleValue() == this.doubleValue());
}