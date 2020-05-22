//Assume that user has no roles in the list, but has been saved to the
//database at a cost of 1 insert.
public void saveOrUpdateRoles(User user, List<Roles> listOfRoles){
    for(Role role : listOfRoles){
        role.setUser(user);
        getCurrentSession.saveOrUpdate(role);
    }
}