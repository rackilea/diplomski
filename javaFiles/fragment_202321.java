// note 1
template<int METHODID, typename Arg1>
struct Wrapper
{
    map<string, SlotFuncPtr> funMap;

    void* GetSlotFunc(const char* className, function<void(Arg1)>* slotFunc)
    {
        funcMap[className] = slotFunc; // note 2
        return StaticJniFunc;
    }

    static JNICALL void StaticJniFunc(JNIEnv* e, jclass c, Arg1 param1)
    {
        auto* slotFunc = funcMap[getClassName(c)]; // note2

        (*slotFunc)(param1);
    }
};

// note1
#define bind_native(name,f) bind_native_<__LINE__>(name,f)