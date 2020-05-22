@Override
public boolean equals(Object obj) {
    if (obj == null || !this.getClass().equals(obj.getClass())) {
        return false;
    }
    return ComparisonChain.start().compare(getId(), ((EntityBase) obj).getId()).result() == 0;
}

@Override
public int hashCode() {
    return (getId() == null) ? super.hashCode() : getId().intValue();
}