private final Environment env;
private final EssentialFilter exampleFilter;

@Inject
public Filters(Environment env, ExampleFilter exampleFilter) {
    this.env = env;
    this.exampleFilter = exampleFilter;
}

@Override
public EssentialFilter[] filters() {

  if (env.mode().equals(Mode.DEV)) {
      return new EssentialFilter[] { exampleFilter };
  } else {
     return new EssentialFilter[] {};
  }
}