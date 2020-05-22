public class MyDTO {
   String type;
   // Fields from BaseType
   String fromBase;
   // Fields from TypeA
   String fromA;
   // Fields from TypeB
   // ...
}


public class BaseType {
  String type;
  String fromBase;

  public BaseType(MyDTO dto) {
    type = dto.type;
    fromBase = dto.fromBase;
  }
}

public class TypeA extends BaseType {
  String fromA;

  public TypeA(MyDTO dto) {
    super(dto);
    fromA = dto.fromA;
  }
}