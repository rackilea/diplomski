public static Result setAdmin(Long userId, int setTo) {
    User user = User.find.byId(userId);
    user.isAdmin = (setTo == 1); // of course isAdmin field of User model is type of Boolean
    user.update(id);
    return ok("User " + user.name + " is " + user.isAdmin);
}