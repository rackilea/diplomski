public static class Dog implements Comparable<Dog> {

    String name;

    public Dog(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public int compareTo(Dog obj) {
        return name.compareTo(obj.name);
    }
}