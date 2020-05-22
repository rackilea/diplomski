User user = null;
try {
    user = User.findById(userId);
} catch (NoSuchCategoryException e) {
    log.error('User {} doesn't exist.', userId);
    user = new User();
}