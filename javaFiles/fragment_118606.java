class MyClass{
   publc void doFunc(){...}
}

class MyLoggedClass extends MyClass{
    MyClass myObject;

    publc void doFunc(){
        //Log doFunc Call

       myObject.doFunc();

    }
}