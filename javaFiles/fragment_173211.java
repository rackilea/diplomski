HttpSession session = request.getSession(false);
if (session == null || session.getAttribute("loggedInUser") == null) {
    // user is not logged in, do something about it
} else {
    // user IS logged in, do something: set model or do whatever you need
}