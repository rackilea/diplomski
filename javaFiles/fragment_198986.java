JNIEnv* env;
bool mustDetach = false;
jint retval = jvm->GetEnv((void**)&env, JNI_VERSION_1_6);
if (retval == JNI_EDETACHED)
{
    JavaVMAttachArgs args;
    args.version = JNI_VERSION_1_6;
    args.name = NULL;
    args.group = NULL;
    retval = jvm->AttachCurrentThread(&env, &args);
    mustDetach = true; // to clean up afterwards
}
if (retval != JNI_OK)
    throw gcnew System::Exception(); // should never happen
invokeJavaCode(env); // next step
if (mustDetach)
    jvm->DetachCurrentThread();