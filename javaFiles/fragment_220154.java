UserService userService = UserServiceFactory.getUserService();
if(!userService.isUserLoggedIn() {
    // No user is logged in (guest)
}
else if(userService.isUserAdmin()) {
   // Admin user
}
else {
    User user = userService.getCurrentUser();
}