template<class T>
class MarkableReference
{
private:
    uintptr_t val;
    static const uintptr_t mask = 1;
public:
    MarkableReference(T* ref = NULL, bool mark = false)
    {
        val = ((uintptr_t)ref & ~mask) | (mark ? 1 : 0);
    }
    T* getRef(void)
    {
        return (T*)(val & ~mask);
    }
    bool getMark(void)
    {
        return (val & mask);
    }
};