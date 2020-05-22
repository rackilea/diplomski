class NumberProvider {
    Number getNumber() { return 1.23; }
}

class IntegerProvider extends NumberProvider {

    // Returning a more specific type when overriding:
    @Override
    Integer getNumber() { return 42; }
}