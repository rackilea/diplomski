// no @Transactional - no need for declarative transaction management
public void addAdmin(String userId) {
    adminRepository.getCtx().transaction(configuration -> {
        DSL.using(configuration)
           .insertInto(Admin.ADMIN)
           .set(Admin.ADMIN.USER_NAME, userId)
           .execute();
    });
}