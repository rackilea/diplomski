// getting the iterator from the list
Iterator<String> users = userList.iterator();

// the first user
if(users.hasNext())
    System.out.println("this is first user :" + users.next());

// the rest of the users
users.forEachRemaining(user -> {
    System.out.println(user);
});