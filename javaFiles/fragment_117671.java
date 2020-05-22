public boolean equals(Object other) {
    if(this == other)
       return true;
    if(!(other instanceof DoubleKey))
       return false;
    DoubleKey that = (DoubleKey)other;
    return (this.key1 == null ? that.key1 == null : this.key1.equals(that.key1)) &&
           (this.key2 == null ? that.key2 == null : this.key2.equals(that.key2));
}