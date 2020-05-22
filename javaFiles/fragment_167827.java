@PostMapping("/questions/{userId}")
public Question createQuestion(@PathVariable Long userId, @Valid @RequestBody Question question) {
    Optional<User> user = userRepository.findById(userId);
    if(userId.isPresent()){
        question.setUser(user.get());
        questionRepository.save(question);
        return question;
    }
    return null;
}