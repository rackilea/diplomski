@Override
public boolean equals(Object obj) {
    if(obj instanceof Car) {
        Car that = (Car) obj;
        return this.carPK.equals(that.carPK);
    }

    return false;
}

@Override
public int hashCode() {
    return this.carPK.hashCode();
}