@Override
public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((first == null) ? 0 : first.hashCode());
    result = prime * result + second;
    return result;
}

@Override
public boolean equals(Object obj) {
    if (this == obj)
        return true;
    if (obj == null)
        return false;
    if (getClass() != obj.getClass())
        return false;
    DataValue other = (DataValue) obj;
    if (first == null) {
        if (other.first != null)
            return false;
    } else if (!first.equals(other.first))
        return false;
    if (second != other.second)
        return false;
    return true;
}