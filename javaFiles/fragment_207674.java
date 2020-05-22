em.save(userGroup);
for(User user : UserGroup.getUsers()) 
{
user.setuser_group_id(userGroup.getUserGroupId());
em.save(user);
}