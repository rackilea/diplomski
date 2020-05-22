public static void main(String args[]) {
    Person p = new Person() {
        void eat() {
            System.out.println("nice fruits");
        }
    };
    p.eat();
}