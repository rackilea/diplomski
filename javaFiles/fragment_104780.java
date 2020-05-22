UserGroups ug = em1.find(UserGroups.class, ...); // entity manager 1
User u = em2.find(User.class, ...); // entity manager 2

// exception will be thrown on commit 
// - from the point of view of em1, "u" is detached
ug.getUsers().add(u);