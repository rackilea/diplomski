User user = userDAO.find(username, password);
if (user != null) {
    sessionMap.put("user", user);
} else {
    // Show error.
}