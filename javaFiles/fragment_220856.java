Map<String, User> usersByKey = new HashMap<>();
for (User user : users)
    usersByKey.put(user.getKey(), user);
for (Issue issue : issues) {
    User user = usersByKey.get(issue.getTitle());
    if (user != null) 
        issue.setTitle(user.getFirstName() + " " + user.getLastName());
}