void main() {
    Dog myLittleDog = new Dog("Brutus");
    change(myLittleDog);
    System.out.println(myLittleDog.getName());
}

void change(Dog aDog) {
    aDog = new Dog("Jack");
}