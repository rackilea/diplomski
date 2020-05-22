int main()
{
    once<int> foo;
    if (1 < -1)
        foo = 21;
    else
        foo = 42;
    std::cout << foo;
    //foo = 23; // uncomment this to get an exception.
}