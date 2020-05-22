public int compareTo(Person other) {
    if (!this.name.equalsIgnoreCase(other.name))
        return this.name.compareTo(other.name);

    // next line returns a String, but the method needs to return an int
    return this.name + " " + other.name;
}