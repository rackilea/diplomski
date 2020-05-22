public final class Person {
    private final int salary;
    private final int age;
    private final double height;
    private final String name;

    public Person(int salary, int age, double height, String name) {
        this.salary = salary;
        this.age = age;
        this.height = height;
        this.name = name;
    }

    // Getters or whatever you want

    public static class Builder {
        // Make each field default appropriately
        private int salary = 1000;
        private int age = 20;
        private double height = 6;
        private String name = "jack";

        public Builder setSalary(int salary) {
            this.salary = salary;
            return this;
        }

        // Ditto for other properties

        public Person build() {
            return new Person(salary, age, height, name);
        }
    }
}