public class ClassA {
    ClassB instanceOfB;
    //getters and setters...
}

public class ClassB {
    ClassA instanceOfA;
    //getters and setters...
}

public class MyJAXWS {

    @WebMethod
    public ClassA getClassA() {
         ClassA classA = new ClassA();
         ClassB classB = new ClassB();
         classB.setInstanceOfA(classA);
         classA.setInstanceOfB(classB);
         return classA; //boom! circular reference problems!
    }
}