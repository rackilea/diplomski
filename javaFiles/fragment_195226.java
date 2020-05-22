void process(Parent parent, Result result) {
    for (Child child : parent.getChildren()) {
        result.update(child);
        process(child, result);
    }
}