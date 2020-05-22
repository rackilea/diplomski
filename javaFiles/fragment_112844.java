public class ClassFactory {

  private ClassFactory() {
  }

  public static AbstractClass<BeanOne> newInstance(BeanOne bean) {
    return new ClassOne(bean);
  }

  public static AbstractClass<BeanTwo> newInstance(BeanTwo bean) {
    return new ClassTwo(bean);
  }
}