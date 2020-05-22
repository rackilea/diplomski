public class SomeClass extends IssuableSubscriptionVisitor {
      @Override
      public List<Tree.Kind> nodesToVisit() {
        return ImmutableList.of(Tree.Kind.METHOD);
      }

      @Override
      public void visitNode(Tree tree) {
        MethodTree methodTree = (MethodTree) tree;
        IdentifierTree methodName = methodTree.simpleName();
       // getName from methodName. 

      }

**get invocation method name**
public class SomeClass extends IssuableSubscriptionVisitor {

    public static IdentifierTree methodName(MethodInvocationTree mit) {
        IdentifierTree id;
        if (mit.methodSelect().is(Tree.Kind.IDENTIFIER)) {
            id = (IdentifierTree) mit.methodSelect();
        } else {
            id = ((MemberSelectExpressionTree) mit.methodSelect()).identifier();
        }
        return id;
    }