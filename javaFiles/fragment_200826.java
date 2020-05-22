<T extends A> T as_T(A a, Class<T> type) {
    if (type.isInstance(a)) 
        return type.cast(a);
    else
        return null;
}