@Override
public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    Address address = (Address) o;

    if (!type.equals(address.type)) return false;
    if (!street.equals(address.street)) return false;
    if (!city.equals(address.city)) return false;
    if (!state.equals(address.state)) return false;
    return zip.equals(address.zip);

}