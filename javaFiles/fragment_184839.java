Map<String, List<User>> usersByCountry = new HashMap<>();

for (User user : listOfUsers) {
    List<User> users = usersByCountry.get(user.getCountry());
    if (users == null) {
        users = new ArrayList<>();
        usersByCountry.put(user.getCountry(), users);
    }
    users.add(user);
}