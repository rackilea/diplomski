%module test

%include <arrays_java.i>

JAVA_ARRAYSOFCLASSES(myStruct1);
JAVA_ARRAYSOFCLASSES(myStruct2);

struct myStruct1 {};
struct myStruct2 {};

bool doSomething(unsigned int x, const myStruct1 typeOne[2], myStruct2 typeTwo[2]);