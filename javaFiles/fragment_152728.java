class MyClass {
    public static void main(String args[]) {
        Person p = new PersonSubclass();
        p.eat();
    }
}  

class PersonSubclass extends Person {
    void eat() {
       System.out.println("nice fruits");
    }
}