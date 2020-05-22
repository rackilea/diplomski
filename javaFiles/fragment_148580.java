public Optional<Spaceship> getById(int id) {
    return Optional.ofNullable(this.byId.get(id));
}
public Optional<Spaceship> getName(String name) {
    return Optional.ofNullable(this.byName.get(name));
}