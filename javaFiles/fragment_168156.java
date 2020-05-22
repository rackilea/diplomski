public static void main(String[] args) {
    Map<String, Toyota> toyotas = new HashMap<>();
    doSomething4(toyotas);

    Toyota t = toyotas.get("hello"); // boom
}

private static void doSomething4(Map<String, Car> cars) {
    cars.put("Hello", new Honda());
}