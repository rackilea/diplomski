@Override
public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + last;
    result = prime * result + ((st == null) ? 0 : st.hashCode());
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
    SetOb other = (SetOb) obj;
    if (last != other.last)
        return false;
    if (st == null) {
        if (other.st != null)
            return false;
    } else if (!st.equals(other.st))
        return false;
    return true;
}