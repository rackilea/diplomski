public static void main(String[] args) {
    doSomething(List.of(Integer.class, Double.class));      // Compiles fine
    doSomethingAgain(List.of(Integer.class, Double.class)); // Does NOT compile
}

static void doSomething(List<Class<? extends Number>> list) {

}

static <T extends Number> void doSomethingAgain(List<Class<T>> list) {

}