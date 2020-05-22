private Object method1Lock = new Object();
private Object method2Lock = new Object();

public void method1(){
    synchronized(method1Lock){
        ....
    }
}

public void method2(){
    synchronized(method2Lock){
        ....
    }
}