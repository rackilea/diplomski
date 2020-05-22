void CallStaticVoidMethod(jclass cls, jmethodID methodID, ...) {
    va_list args;
    va_start(args,methodID);
    functions->CallStaticVoidMethodV(this,cls,methodID,args);
    va_end(args);
}