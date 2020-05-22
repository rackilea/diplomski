private static Product createByString(String name) {
    switch (name) {
        case "productA": new productA();
        case "productB": new productB();
        // ... maybe more?
        default: throw new IllegalArgumentException("name " + name + " is not a valid Product");
    }
}