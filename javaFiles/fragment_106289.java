void bar();

namespace some_namespace
{
    void bar();

    void foo()
    {
        // writing bar() would call some_namespace::bar()
        // but if we want to call the global bar() we have to write:
        ::bar();
    }
}