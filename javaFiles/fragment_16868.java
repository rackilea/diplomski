static class Parent {}
static class Child extends Parent {}
static class IllegitimateChild extend Parent {}

public static void main(String args[]) {
    List<Child> children = new ArrayList<>();
    computeSomething(children);
    Child c = children.get(0); //WTF - ClassCastException?? IllegitimateChild is not a Child
}

public static void computeSomething(List<Parent> items) {
    parents.add(new IllegitimateChild());
}