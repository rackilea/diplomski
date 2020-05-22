UserGroup firstUserGroup = new UserGroup();
firstUserGroup.setTitle("Admin");
List<User> users = new ArrayList<>();
// change
User user = userService.find(1);
List<UserGroup> groups = new ArrayList<>();
groups.add(firstUserGroup);
user.setUserGroups(groups);
// end change
users.add(user);          
firstUserGroup.setUsers(users);
userGroupService.save(firstUserGroup);
...