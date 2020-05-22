public abstract class A_SuperClass {
    public A_SuperClass createNewFromSubclassType(A_SuperClass toCreateNewFrom) {
        A_SuperClass result = null;
        if (toCreateNewFrom != null) {
            result = toCreateNewFrom.getClass().newInstance();    
        }
        // just an example, add try .. catch and further detailed checks
        return result;
    }
}

public class SubClassA extends A_SuperClass {

}

public class SubClassB extends A_SuperClass {

}