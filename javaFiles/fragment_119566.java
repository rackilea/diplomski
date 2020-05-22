class ClassB extends ClassA{
    // bridge method
    void method(Number i){
        method((Integer)i);
    }

    void method(Integer i){}
}