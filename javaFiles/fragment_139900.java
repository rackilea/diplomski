public static void main(String[] args) {
    List<MyClass> data = new ArrayList<>();
    data.add(new MyClass("1", "A", "B"));
    data.add(new MyClass("2", "A", "B"));
    data.add(new MyClass("3", "A", "C"));
    data.add(new MyClass("4", "B", "A"));

    System.out.println(groupListBy(data, new String[] { "type", "module" }));
}