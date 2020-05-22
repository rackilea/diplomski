public CompletionStage<Result> test(String path, String file) {
    if (StringUtils.isEmpty(path)) {
        throw new IllegalArgumentException();
    }

    return assets.at(path, file, false).asJava().apply(request()).run(materializer);
}