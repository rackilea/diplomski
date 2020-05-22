public class YourApplication{
    public static void main(String args[]){
        YourClass instance1 = new YourClass();
        YourClass instance2 = new YourClass();

        instance1.pleaseGiveYourFunctionProperNames("Hello");
        instance1.thisFunctionPrintsValueOfMyStringVar(); // This prints "Hello"

        instance2.pleaseGiveYourFunctionProperNames("World");
        instance2.thisFunctionPrintsValueOfMyStringVar(); // This prints "World"
        instance1.thisFunctionPrintsValueOfMyStringVar(); // This prints "World, NOT Hello, as you'd expect"
    }
}