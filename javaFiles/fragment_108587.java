// Dealing with first user only
if (!userList.isEmpty()) {
    System.out.println("this is first user: " + userList.get(0));
}
// using stream skipping the first element
userList.stream().skip(1).forEach(user -> {
    System.out.println(user);
});