public Either<String, Integer> doSomething() {
    // ...
    return integerOption.map(
        Either::<String, Integer>right).getOrElse(
            () -> Either.left("Error message"));
}