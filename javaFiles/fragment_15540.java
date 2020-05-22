public interface Builder<T extends BasicFoo> {
 public void buildFoo(T foo);
}

public class BasicFooBuilder<T extends BasicFoo> implements Builder<T> {
 @Override
 public void buildFoo(BasicFoo foo){
  //Do something
 }
}

public class FancyFooBuilder<T extends FancyFoo> extends BasicFooBuilder<T> {
 @Override
 public void buildFoo(T foo){
  foo.doSomethingFancy();
 }
 //More stuff inherited from basic foo
}

public class FancierFooBuilder<T extends FancierFoo> extends FancyFooBuilder<T> {
 @Override
 public void buildFoo(T foo){
  foo.doSomethingFancier();
 }
 //More stuff inherited from basic foo and fancy foo
}