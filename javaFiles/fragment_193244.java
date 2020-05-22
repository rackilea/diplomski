public List<Entry> getEntriesForUserId(int userId) {
    return DataBaseConnector
             .getAllUsers()
             .stream()
             .filter(user -> user.getUserId() == userId)
             .findFirst()
             .orElse(new User(-1, "Error")
             .getEntries();
}