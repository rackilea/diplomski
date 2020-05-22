public class MyClass {

    // ...

    public int calculateAgeDifference(MyClass other) {
        int age = other.age; // This hides this.age, don't do this
        return this.age - age;
    }
}