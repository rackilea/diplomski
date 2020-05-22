client.send(new TdApi.GetUser(userId), result -> {
  if (result.getConstructor() != User.CONSTRUCTOR) {
    System.out.println("Error occurred: " + result);
    return;
  }
  User user = (User) result;
  System.out.println(user.firstName);
  System.out.println(user.lastName);
  System.out.println(user.username);
});