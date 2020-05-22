public static void main(String[] args) {
    methodWithException();
}

private static void methodWithException() {
    try {
        throw new Exception("Hello");
    } catch (Exception e) {
        Lombok.sneakyThrow(e);
    }
}