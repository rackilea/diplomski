public boolean equals(Object o) {
    if(!(o instanceof CityLoader))
        return false;
    CityLoader other = (CityLoader)o;
    return other.name.equals(this.name);
}