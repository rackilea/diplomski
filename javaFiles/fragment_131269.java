public interface IFoo {

  <T> void method1(Bar<T> bar);

  /* Many other methods that don't use Bar…  */

}