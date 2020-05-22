public Foo(Entity entity) {
  // TODO get properties from entity and populate POJO
  this.bar=entity.getProperty("bar");
  //get the key
  //if the @PrimaryKey is a Long use this
  this.id=entity.getKey().getId();
  //if the @PrimaryKey is a String use this
  this.id=entity.getKey().getName();
}