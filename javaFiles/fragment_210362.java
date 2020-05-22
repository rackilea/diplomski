@Override
public boolean equals(Object o) {
    if (this == o) {
        return true;
    }
    if (!(o instanceof StringNumber)) {
        return false;
    }
    StringNumber that = (StringNumber) o;
    if (number != null ? !number.equals(that.number) : that.number != null) {
        return false;
    }
    return !(string != null ? !string.equals(that.string) : that.string != null);

}

@Override
public int hashCode() {
    int result = string != null ? string.hashCode() : 0;
    result = 31 * result + (number != null ? number.hashCode() : 0);
    return result;
}