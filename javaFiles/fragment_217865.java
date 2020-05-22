@Retention(RetentionPolicy.RUNTIME)
@interface MyAnnotation { }

@MyAnnotation
class Foo {
  @MyAnnotation
  public void bar() { }
}