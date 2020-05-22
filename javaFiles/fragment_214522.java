pubic class User {
  ...
  @ManyToMany
  @JoinTable(name="USER_ROLE")
  private List<Role> roles;
  ...
}