public class Legacy1Wrapper implements VisitableWrapper {

    private final Legacy1 legacyObj;

    public Legacy1Wrapper(Legacy1 original){
        this.legacyObj = original;
    }

    public void accept(Visitor visitor){
         visitor.visit(legacyObj);
    }
}