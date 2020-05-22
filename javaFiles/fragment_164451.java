class A {
int i=5;
public void doSomething(){
//print "in A"
}
}

class B extends A{
int i=10;    
public void doSomething(){
// print "in B"
}

public static void main(String[] args){
A a = new B();
a.doSomething();
}
}