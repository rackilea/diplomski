void foo(ChangeingMember member) { // <-- dependency
    member.test1();    
}

void bar() { // <-- no dependency
    SomeGlobal.someMethod();
}