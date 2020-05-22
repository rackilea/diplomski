interface A{
    void run();
}

interface B{
    String run();
}

class C implements A, B{
    ???? run() {}
}