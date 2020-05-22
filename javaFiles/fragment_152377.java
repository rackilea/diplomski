@Secured({ "ROLE_USER" })
 public void create(Contact contact);

 @Secured({ "ROLE_USER", "ROLE_ADMIN" })
 public void update(Contact contact);

 @Secured({ "ROLE_ADMIN" })
 public void delete(Contact contact);