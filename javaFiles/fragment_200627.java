void *JavaCalls::javaMethodA(type1 arg1, type2 arg2, type3 arg3) 
{
    jobject javaObject = CallStaticObjectMethod(jMain, "methodA",...);
    return NewGlobalRef(jMain, javaObject);
}

void JavaCalls::javaMethodB(void* javaObject) {
     CallStaticVoidMethod(jMain, "methodB", static_cast<jobject>(javaObject));
}

// add this method - it should be called when you finish using the object
void JavaCalls::ReleaseObject(void* javaObject) {
     DeleteGlobalRef(jMain, static_cast<jobject>(javaObject));
}