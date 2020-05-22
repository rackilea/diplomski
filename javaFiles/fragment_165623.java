class MyFinder extends ASTVisitor {
  public void postVisit(ASTNode node) {
    if (spansProblemLocation(node)) {
      throw new VisitComplete(node);
    }
  }
}
class VisitComplete extends Throwable {
  ASTNode result;
  ...
}