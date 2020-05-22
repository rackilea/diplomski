public abstract class Animal {
    protected int age;
    public A() {}
    public A(int _age) {
        this.age = _age;
    }
}

public class Bulldog extends Animal {
    public Bulldog() {}
    public Bulldog(int _age) {
        super(_age + 1);
    }
}

public class Cat extends Animal {
    public Cat() {}
    public Cat(int _age) {
        super(_age);
    }
    public int getAge() {
        return this._age;
    }
}