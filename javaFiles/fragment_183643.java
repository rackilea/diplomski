@Override
public int hashCode() {
    int result = type.hashCode();
    result = 31 * result + street.hashCode();
    result = 31 * result + city.hashCode();
    result = 31 * result + state.hashCode();
    result = 31 * result + zip.hashCode();
    return result;
}