class SomeClass {
    SomeClass(String someString, float someFloat, int... someArray) {
        println(someString);
        println(someFloat);
        println(someArray);
    }
}
SomeClass myVar = new SomeClass("lol",3.14, 12, 10);