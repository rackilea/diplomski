private String code;
private int count;
//getters, setters

@Override
public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((code == null) ? 0 : code.hashCode());
    result = prime * result + count;
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
    Country other = (Country) obj;
    if (code == null) {
        if (other.code != null)
            return false;
    } else if (!code.equals(other.code))
        return false;
    if (count != other.count)
        return false;
    return true;
}