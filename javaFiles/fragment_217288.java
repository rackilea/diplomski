OtherClass otherClass; // whose methods all throw exceptions in test environment.

public String someMethod(int arg){
    otherClass.methodWeWantMocked();
    otherMethod();
    return "";
}