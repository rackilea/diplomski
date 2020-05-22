@Overrides
public boolean equals(Object that) {
    if (that == null) {
        return false;
    }
    if (this.getName() == null) {
        return that.getName() == null;
    }
    return this.getName().equals(that.getName());
}