public Validation validateSomething() {
    if (condition) {
        return new Validation("msg.key", ValidationType.ERROR);
    }
    return new Validation(null, ValidationType.OK);
}