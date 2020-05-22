@Bean
public RoleHierarchy roleHierarchy() {
  RoleHierarchyImpl r = new RoleHierarchyImpl();
  r.setHierarchy("ROLE_ADMIN > ROLE_STAFF and ROLE_ADMIN > ROLE_DEVELOPER and ROLE_STAFF > ROLE_USER and ROLE_DEVELOPER > ROLE_USER");
  return r;
}