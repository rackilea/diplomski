Optional<Topic> topic = getTopic();
if (topic.isPresent()) {
    List<Comment> comments = topic.get().getComments()
        .stream()
        .filter(comment -> "comment1".equals(comment.getName()))
        .collect(Collectors.toList());
}