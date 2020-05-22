public static void main(String[] args) {
    try {
        String obj = (String) MyClass.castToAnotherType(new Object());
    } catch (ClassCastException e) {
        System.out.print("Exception outside castToAnotherType()");
    }
}