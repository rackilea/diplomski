public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((addressLine1 == null) ? 0 : addressLine1.hashCode());
    result = prime * result + ((state == null) ? 0 : state.hashCode());
    result = prime * result + ((country == null) ? 0 : country.hashCode());
    return result;
}