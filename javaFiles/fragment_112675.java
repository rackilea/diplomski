private void setIdChecked(int id) {
    if (id < 0) {
        throw new IllegalArgumentException("id must be a positive.");
    }
    this.id = id;
}
public void setId(int id) {
    setIdChecked(id);
}
public Person(int id) {
    setIdChecked(id);
}