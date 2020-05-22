public static List<Function<MyObject, String>> getExtractors() {
    return Arrays.asList(
            o -> String.valueOf(o.getKey1()),
            MyObject::getKey2,
            MyObject::getKey3
    );
}

.flatMap(o -> getExtractors().stream().map(extractor -> extractor.apply(o)))