@Override
public boolean equals(Object obj) {
    if ( ! obj instanceof Company ) {
        return false;
    }

    Company other = (Company) obj;

    return this.b.equals(other.b) && this.n.equals(other.n);
}