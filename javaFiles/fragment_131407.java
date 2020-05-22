public boolean equals(final Object other) {
  if (other instanceof NewClass) {
    final NewClass _other = (NewClass) other;
    return name.equals(_other.name)
      && (surname == null && surname == _other.surname
        || surname.equals(_other.surname))
      && (address == null && address == _other.address
        || address.equals(_other.address));
  } else {
    return false;
  }
}

public int hashCode() {
  return name.hashCode() * 961
    + (surname == null ? 0 : surname.hashCode()) * 31
    + (address == null ? 0 : address.hashCode());
}