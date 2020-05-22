LoginBean user = (LoginBean) session.getAttribute("currentSessionUser");

if (user != null) {
    String userName = user.getUserName();
    // ...
}