class ClassA {
    String whoAmI() {
        return "ClassA";
    }
}

class ClassB extends ClassA{
    // override whoAmI method change function
    String whoAmI() {
        //do something
        int foo = 5 + 10;
        return "ClassB foo: "+foo;
    }
}