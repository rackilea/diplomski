class MyClass
{
public:
    int a = 1;
};

class Derived : public MyClass
{
public:
    int b = 2;
};

class NotDerived
{
public:
    int b = 3;
};

template<typename T, typename std::enable_if<std::is_base_of<MyClass, T>::value>::type* = nullptr>
T Foo(T bar)
{
    return T();
}

int main()
{
    Derived d;
    NotDerived nd;
    std::cout << Foo(d).b << std::endl;; // works
    //std::cout << (Foo(nd)).b << std::endl;; //compiler error

    return 0;
}