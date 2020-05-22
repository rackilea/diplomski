public class SomeLegacyVisitor{

    public void visit(Legacy1 leg){
        System.out.println("This is a Legacy1! let's do something with it!");
        leg.someBusinessMethod1();
    }

    public void visit(Legacy2 leg){
        System.out.println("Hum, this is a Legacy 2 object. Well, let's do something else.");
        leg.anotherBusinessMethod();
    }
}