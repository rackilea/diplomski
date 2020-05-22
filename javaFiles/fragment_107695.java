// Java code
public abstract class Base<T extends Base> {
      public abstract T copy();
}

// Scala
class FromBase extends Base[FromBase] {
    override def copy() = new FromBase
}