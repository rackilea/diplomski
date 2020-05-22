class MyClass{
  private Class<? extends Enum<?>> enumType;

  void <T extends Enum<T>> setEnumType(Class<T> enumType){
     this.enumType = enumType;
  }

  void doSomething(){
     for (Enum<?> literal : enumType.getEnumConstants()) {
         // do something with literal.name();
     }
  }