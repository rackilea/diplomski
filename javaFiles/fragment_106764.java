void setID(int id) throws IllegalArgumentException {
    if(id < 0) {
        throw new IllegalArgumentException();
    } else {
        this.id = id;
    }
}