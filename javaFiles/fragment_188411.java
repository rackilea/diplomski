@Transactional
public User save(User newUser) {
    User currentUser = userRepository.get(newUser.getId());
    // handle merging of updated columns onto currentUser manually or via some mapping tool
    currentUser.setName(newUser.getName());
    return userRepository.save(currentUser);
}