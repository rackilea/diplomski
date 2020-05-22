template<class T>
class MyClass
{
    static_assert( std::is_base_of< OtherClass, T >::value, "T does not extend OtherClass");

public:
    MyClass();
};