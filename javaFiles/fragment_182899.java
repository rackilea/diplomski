Collection<User> users = roster.getEntries();
if(!users.isEmpty()) {
    Collections.sort(users, SORT_BY_NAME_COMPARATOR);
    for(User user: users) {
        // do something
    }
}