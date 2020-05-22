public class TestClass{
    // Start off with some legacy objects
    Legacy1 leg1 = ...
    Legacy2 leg2 = ...

    // Wrap all your legacy objects into a List:
    List<VisitableWrapper> visitableLegacys = new ArrayList<>();
    visitableLegacys.add(new Legacy1Wrapper(legacy1));
    visitableLegacys.add(new Legacy2Wrapper(legacy2));

    // Use any of your visitor implementations!
    Visitor visitor = new SomeLegacyVisitor();
    for(VisitableWrapper wrappedLegacy: visitableLegacys){
        wrappedLegacy.accept(visitor);
    }
}