Class<User> cl = User.class;
for (Method m : cl.getMethods()) {
    System.out.println(m.getName());
}
for (Field f : cl.getFields()) {
    System.out.println(f.getName());
}