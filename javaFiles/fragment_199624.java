try {
    return Optional.of(User.findById(userId));
} catch (NoSuchCategoryException e) {
    log.error('User {} doesn't exist.', userId);
    return Optional.empty();
}