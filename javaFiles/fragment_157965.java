public abstract class AbsClass<Q extends Interf, M extends AbsClass<Q, M>> {
  public abstract Ref<M> getRef();
  public abstract void setRef(Ref<M> newRef);
}

public class ChildClass extends AbsClass<InterfImpl, ChildClass> {

  public Ref<ChildClass> getRef() { return null; }

  public void setRef(Ref<ChildClass> newRef) { }
}