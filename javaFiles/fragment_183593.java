@Override
public int hashCode() {
    HashCodeBuilder hcb = new HashCodeBuilder(17, 37);
    hcb.append(this.getName());
    return hcb.toHashCode();
}