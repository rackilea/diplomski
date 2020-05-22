class City {
    String name;
    String postalCode;

    @Override public boolean equals(Object obj) {
        if (!(obj instanceof City)) {
            return false;
        }

        City that = (City) obj;

        return Objects.equals(this.name, that.name)
            && Objects.equals(this.postalCode, that.postalCode)
    }

    @Override public int hashCode() {
        return Objects.hash(name, postalCode);
    }
}