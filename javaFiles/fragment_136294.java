Interface MyInterface 
          {
             int myVar;
             void myMethod (int var);
          }

    class MyClass implements MyInterface // with comma(,) you can separate multiple interfaces
 {
    void myMethod (int var) {//do something}
    int myVar = 1;
    }