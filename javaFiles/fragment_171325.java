package test;

@Primary
@Component
public class Parent {
  @Resource
  Child child;

  public Child getChild() {
    return child;
  }
}