public void methodA(){
    methodB();
    Object o = new Object();
    methodC(o);
}

public void methodB(){
    //do something
}

public void methodC(Object o){
    o.doSomething();
}