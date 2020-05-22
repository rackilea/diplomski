public class Legacy2Wrapper implements VisitableWrapper {

    private final Legacy2 legacyObj;

    public Legacy2Wrapper(Legacy2 original){
        this.legacyObj = original;
    }

    public void accept(Visitor visitor){
         visitor.visit(legacyObj);
    }
}