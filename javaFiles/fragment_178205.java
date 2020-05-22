template<typename T>
class once
{
private: 
    std::aligned_storage_t<sizeof(T), alignof(T)> data;
    T* ptr = nullptr;
public:
    once() = default;
    ~once()
    {
        if(ptr) // it is initialized so call the destructor
            ptr->~T();
        // optionally you can add
        // throw("a once<T> must be initialized once");
        // this can help to enforce that the object is actually initialized as you'll get a runtime exception in code that does not do so
    }
    template<typename U>
    once& operator =(U&& value)
    {
        if (!ptr) // it is not initialized so call constructor
        {
            ptr = new(&data) T(std::forward<U>(value));
        }
        else
            throw ("can only assign to a once<T> once.");
        return *this;
    }
    operator const T&()
    {
        return *ptr;
    }

};