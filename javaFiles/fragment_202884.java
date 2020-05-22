public Person(PersonEntity entity, boolean banned) { 
  this.person = entity;
  this.banned = banned;
}

public boolean isBanned() {
  return banned;
}