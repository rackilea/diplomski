[public] class MyClass {
  static
  {
    ...
    props.load(MyClass.class.getResourceAsStream("/someProps.properties"));
  }
}