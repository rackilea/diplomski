class Person {
  Set<Role> roles = new EnumSet<Role>();
  public void addRole(Role role) { ... }
  public void removeRole(Role role) { ... }
  public boolean hasRole(Role role) { ... }
}