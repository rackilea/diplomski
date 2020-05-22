GenericMap map = new GenericMap();

map.putClassAndInstance(User.class, new User()); // valid
map.putClassAndInstance(User.class, new UserSubclass()); // valid
map.putClassAndInstance(Role.class, new Role()); // valid
map.putClassAndInstance(User.class, new Role()); // invalid, compiler error