// Do something with the first user only
if(!userList.isEmpty())
    System.out.println(userList.get(0));

// Do some stuff for all users in the list except the first one
userList.subList(1, userList.size()).forEach(user -> {
        System.out.println(user + " All users without 0");
);

// Do some stuff for all users in the list
userList.forEach(user -> {
        System.out.println(user + " All users");
);