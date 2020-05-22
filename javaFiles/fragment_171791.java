public boolean deleteUser(Principal principal) {
    User loggedUser = findLoggedInUser(principal);
    if (loggedUser != null) {
        userRepository.delete(loggedUser);
        return true;
    }
    return false;
}