public U informAll2(T t){
    for(U u:mListeners){
        u.hearChange(t);
        if (...)
            return u;
    }
}