public class ClassMain{

    public static void main(String... args){
        ClassB classB = new ClassB();//Will throw an error
        ClassA classA = new ClassA();//Will compile fine

        ClassB.doSomething(ClassB.doSomethingElse());//Will compile fine
        classB.doSomething(classB.doSomethingElse());//Will give a warning

        ClassA.doSomething(ClassA.doSomethingElse());//Will throw an error
        classA.doSomething(classA.doSomethingElse());//Will compile fine
    }
}