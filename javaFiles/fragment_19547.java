template<typename T>
static inline void nullcheck(T *ptr) { 
    #if PLATFORM_TRAITS_NEW_RETURNS_NULL
        if (ptr == NULL) throw std::bad_alloc();
    #endif
}