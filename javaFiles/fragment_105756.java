public class HelloWorld {
     public void common() {
          [commonCode]
     }
}

public class Child1 extends HelloWorld {
     public void someLogic() {
          super.common();
          ...
     }
}

public class Child2 extends HelloWorld {    
     public void someOtherMethod() {
          super.common();
          ...
     }
}