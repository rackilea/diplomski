protected Group[] getRoleSets() throws LoginException {
  SimpleGroup callerPrincipal = new SimpleGroup("CallerPrincipal");
  callerPrincipal.addMember(this.getIdentity()); <--- YOUR PRINCIPAL OBJECT
  Group[] roleSets = { userRoles , callerPrincipal };
  return roleSets;
}