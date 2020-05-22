public interface KeyVisitor {
  void visitInternalKey(InternalKey k);
  void visitFooBarKey(FooBarKey k);
}

public interface Key {
  void visit(KeyVisitor kv);
}

public class InternalKey implements Key {
  public void visit(KeyVisitor kv) {
    kv.visitInternalKey(this);
  }
}