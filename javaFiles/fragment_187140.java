Domain domain = new ByteBuddy()
  .subclass(Domain.class)
  .method(isDeclaredBy(Domain.class))
  .intercept(FieldAccessor.ofField("id").defineAs(int.class, Visibility.PRIVATE))
  .make()
  .load(Sample.class.getClassLoader())
  .getLoaded()
  .newInstance();

  domain.setIdentifier(42);
  System.out.println(domain.getIdentifier());