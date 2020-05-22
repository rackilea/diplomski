@Override
public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((v1 == null) ? 0 : v1.hashCode());
    result = prime * result + ((v2 == null) ? 0 : v2.hashCode());
    return result;
}