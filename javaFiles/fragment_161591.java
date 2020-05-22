class ClassA {
    String whoAmI() {
        return "ClassA";
    }
}

class ClassB extends ClassA{
    // you are overloading the method whoAmI from class A
    String whoAmI(String name) {
        return "ClassB "+name;
    }
}