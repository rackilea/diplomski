package spring.aop;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

class SampleClass {
  public void x() {
    System.out.println("x");
    y();
  }

  public void y() {
    System.out.println("y");
  }

  public static void main(String[] args) {
    Enhancer enhancer = new Enhancer();
    enhancer.setSuperclass(SampleClass.class);
    enhancer.setCallback(new MethodInterceptor() {
      @Override
      public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy)
        throws Throwable {
        if(method.getDeclaringClass() == Object.class)
          return proxy.invokeSuper(obj, args);
        System.out.println("Before proxy.invokeSuper " + method.getName());
        Object result = proxy.invokeSuper(obj, args);
        System.out.println("After proxy.invokeSuper " + method.getName());
        return result;
      }
    });
    SampleClass proxy = (SampleClass) enhancer.create();
    proxy.x();
  }
}