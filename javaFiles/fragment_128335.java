@Override
public boolean equals(Object ob) {
    if (!ob instanceof Car) return false;
    Car that = (Car)ob;
    return this.number == that.number;
}

@Override
public int hashCode() {
    return number;
}