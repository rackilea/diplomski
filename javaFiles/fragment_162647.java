aspect MyAspect {
    public S MyInterface<S>.getMyself() {
        return (S) this;
    }  
}

interface MyInterface<T extends MyInterface<T>> {
}

class MyClassOne implements MyInterface<MyClassOne> {}
class MyClassTwo implements MyInterface<MyClassTwo> {}

class Main {
    public static void main(String[] args) {
        MyClassOne aClassOne = new MyClassOne().getMyself();
        MyClassTwo aClassTwo = new MyClassTwo().getMyself();
        MyClassOne errorClassOne = new MyClassTwo().getMyself(); // compile error
        MyClassTwo errorClassTwo = new MyClassOne().getMyself(); // compile error
    }
}