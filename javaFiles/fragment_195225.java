Result process(Parent parent) {
    Result result = new Result();
    for (Child child : parent.getChildren()) {
        result.update(process(child));
    }
    return result;
}