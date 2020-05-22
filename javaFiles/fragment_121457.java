class MyOb {

private String name;
private Integer quality;
private final int MAXIMUM = 23;

@Override
public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((name == null) ? 0 : name.hashCode());
    result = prime * result + ((quality == null) ? 0 : quality.hashCode());
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
    MyOb other = (MyOb) obj;
    if (name == null) {
        if (other.name != null)
            return false;
    } else if (!name.equals(other.name))
        return false;
    if (quality == null) {
        if (other.quality != null)
            return false;
    } else if (!quality.equals(other.quality))
        return false;
    return true;
}