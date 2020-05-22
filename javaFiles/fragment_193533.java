// it returns NULL in the case of an exception
// the returned memory is calloc()'d; it's the caller's responsibility to free() it.
char* changeEncoding(const char*source, int len, int direction)
{
    JNIEnv* env = threadUnsafeInfo.env;
    jobject obj = threadUnsafeInfo.obj;

    if (!source) {
    JNU_ThrowByName(env, "java/lang/NullPointerException", 0);
    return NULL;
    }
    jbyteArray srcArray = env->NewByteArray(len);

    jclass cls = env->FindClass("com/xyz/MyClass");
    jmethodID mid = env->GetMethodID(cls, "convert", "([BI)[B");

    if (mid != NULL && srcArray != NULL) {
    env->SetByteArrayRegion(srcArray, 0, len, (jbyte*)source);
    env->ExceptionClear();

    //jbyteArray resArray = (jbyteArray)env->CallStaticObjectMethod(cls, mid, srcArray, direction);
    jbyteArray resArray = (jbyteArray)env->CallObjectMethod(obj, mid, srcArray, direction);
    if(env->ExceptionOccurred()) {
        DLOG("exception in convert ([BI)[B");
        env->ExceptionDescribe();
        //env->ExceptionClear(); // ??
        return NULL;
    }

    int resultLen = env->GetArrayLength(resArray);
    char* result = (char*)calloc(2 + resultLen,1); // why 2: a bit of healthy paranoia ain't gonna hurt anyone
    if (result == 0) {
        JNU_ThrowByName(env, "java/lang/OutOfMemoryError", 0);
        return NULL;
    }
    env->GetByteArrayRegion(resArray, 0, resultLen, (jbyte *)result);
    env->DeleteLocalRef(cls);
    env->DeleteLocalRef(resArray);
    env->DeleteLocalRef(srcArray);
    return result;
    } else {
    JNU_ThrowByName(env, "java/lang/NullPointerException", 0);
    myassert(("method id = 0",0));
    }
    return NULL;
}