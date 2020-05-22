class SomeClass {
    SomeClass(String someString, int... someArray, float someFloat) {
        println(someString);
        println(someFloat);
        println(someArray);
    }
}
SomeClass myVar = new SomeClass("lol", 12, 10,3.14);