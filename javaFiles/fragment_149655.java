public interface Type { 
  public Type copy();
}

public interface SubType extends Type { 
  public SubType copy();
}

public class Concrete implements Type { 
  @Override
  public Concrete copy() {
    return new Concrete();
  }
}

public class SubConcrete implements SubType {
  @Override
  public SubConcrete copy() {
    return new SubConcrete();
  }
}

public static void main(String[] args) {
  Type    type    = new Concrete();
  SubType subType = new SubConcrete();

  Type    newType    = type.copy();
  SubType newSubType = subType.copy();
}