public static <T extends Throwable> T withExclamationMark(
        T error, 
        BiFunction<String, T, T> factory) {

    return factory.apply(error.getMessage() + "!", error);
}