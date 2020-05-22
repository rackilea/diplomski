User u = new User();
// populate u fields

Address a = new Address();
a.setUser(u);
// populate a fields

session.persist(a);