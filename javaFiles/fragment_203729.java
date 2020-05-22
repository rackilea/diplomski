class MyEnumProvider implements Provider<MyEnum> {
  @Override
  public MyEnum get() {
    return MyEnum.FOO;
  }
}
…
bind(MyEnum.class).toProvider(MyEnumProvider.class);