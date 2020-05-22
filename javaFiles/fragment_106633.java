@Transactional
public Boolean addBookmark(Long userId, Long bookId) {
    Optional<Book> book = bookRepository.findById(bookId);
    Optional<User> userOp = userRepository.findById(userId);

    if (book.isPresent() && userOp.isPresent()) {
        User user = userOp.get();
        int size = user.getSpectatingBooks().size();
        user.getSpectatingBooks().put(book.get(), Integer.toUnsignedLong(0));
        userRepository.save(user);
        return true;
    }

    return false;
}