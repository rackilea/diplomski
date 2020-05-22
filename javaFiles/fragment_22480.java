MyClass { 
void methodA(){}
void methodB(){}
}

MeasuringClass {
  public static void main(String[] args){
    MyClass cc = new MyClass()
    long startTime = System.currentTimeMillis();
    cc.methodA();
    cc.methodB();

    // here is the duration of all methods invoked
    long duration = System.currentTimeMillis()-startTime;
  }
}