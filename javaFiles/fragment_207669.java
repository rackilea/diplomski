interface Role {
  ...
}

final class Client implements Role {
  ...
}

final class Provider implements Role {
  ...
}

final class Agent implements Role {
  ...
}

class Person {
  List<Role> roles;
  public void addRole(Role role) { ... }
  public void removeRole(Role role) { ... }
  public Role getRoleOfType(Class<? extends Role> roleType) { ... }
}