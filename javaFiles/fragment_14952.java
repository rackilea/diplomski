public class Foo {
  private final TaskExecutor executor;

  @Inject
  public Foo(TaskExecutor executor) {
    this.executor = executor;
  }
}