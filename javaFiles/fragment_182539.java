doSomething(CommentSubject subject) {
    Integer optLine = subject.line();
    if (optLine != null) {
        int line = optLine.intValue();
        ...
    }
    ...
}