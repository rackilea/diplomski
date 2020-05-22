ClassReloadingStrategy classReloadingStrategy = ClassReloadingStrategy
                                                   .fromInstalledAgent();
new ByteBuddy()
  .redefine(Foo.class)
  .method(named("getHello"))
  .intercept(FixedValue.value("Byte Buddy!"))
  .make()
  .load(Foo.class.getClassLoader(), classReloadingStrategy);
assertThat(foo.getHello(), is("Byte Buddy!"));
classReloadingStrategy.reset(Foo.class);
assertThat(foo.getHello(), is("Hello World"));