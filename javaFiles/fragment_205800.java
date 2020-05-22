//Create one UserItem instance here
Set<UserItem> userItems = user.getUserItems();
//Create another UserItem instance here
UserItem userItem = userDAO.findUserItem(user,  itemShop);
userItems.remove(userItem);

//Hibernate doesn't know which UserItem instance to remove, and throws an exception.
session.saveOrUpdate(user);
session.flush();