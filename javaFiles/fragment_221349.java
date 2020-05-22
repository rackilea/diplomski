public Response createUser(User user) {
    if (user == null || user.getId() == null) {
        throw new ResourceNotFoundException("Empty", "Missing Data Exception");
    } else {
        User user = userRepository.save(user);
        return new Response(user.getId);
    }
}