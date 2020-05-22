default User softDelete(UUID id) {
    User existingUser = findOne(id);
    if (existingUser != null) {
        existingUser.setActive(false);
    } else {
        throw new EntityNotFoundException();
    }
    return existingUser;//you may want to save this user again with isActive flag now false
}