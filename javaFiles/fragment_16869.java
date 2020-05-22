public static void main(String[] args) {
    List<? extends Parent> items = new ArrayList<Child>();

    items.add(new IllegitimateChild()); // Compiler error
    items.add(new Child()); // Compiler error
}