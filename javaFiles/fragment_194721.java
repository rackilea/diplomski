User user = userDAO.find(username, password);
if (user != null) {
    session.setAttribute("user", user);
} else {
    // Show error like "Login failed, unknown user, try again.".
}