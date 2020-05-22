public static void doingSomething(){
    try {
        if (something[i] >= something_else) { ... }
    } catch (ArrayIndexOutOfBoundsException e) {
        System.out.println("Method Halted!, continuing doing the next thing");
    }
}