public class MyRootA extends AbstractRoot<MyRootA> {
    //R is MyRootA - "this" is an instance of R
}

public class MyRootB extends AbstractRoot<MyRootA> {
   //R is MyRootA - "this" is NOT an instance of R
}