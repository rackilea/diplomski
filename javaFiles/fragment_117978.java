=====> cat test_return.cpp
extern void something();
extern void something2();

void test(bool b)
{
    if(b)
    {
        something();
    }
    else
        something2();
}
=====> cat test_return2.cpp
extern void something();
extern void something2();

void test(bool b)
{
    if(b)
    {
        something();
        return;
    }
    something2();
}
=====> rm -f test_return.s test_return2.s
=====> g++ -S test_return.cpp 
=====> g++ -S test_return2.cpp 
=====> diff test_return.s test_return2.s
=====> rm -f test_return.s test_return2.s
=====> clang++ -S test_return.cpp 
=====> clang++ -S test_return2.cpp 
=====> diff test_return.s test_return2.s
=====>