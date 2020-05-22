public boolean equals(Object o) {
    boolean result = false;
    if (o instanceof Person) {
        Person other = (Person) o;
        if (this.getName().equals(other.getName())
              && this.getDob().equals(other.getDob())) {
            result = true;
        }

    }
    return result;
}