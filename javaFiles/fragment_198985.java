JavaVMInitArgs initArgs;
initArgs.version = JNI_VERSION_1_6;
initArgs.nOptions = 0;
JavaVM* jvm;
JNIEnv* env;
if ((retval = createJavaVM(&jvm, &env, &initArgs)) != JNI_OK)
    throw gcnew System::Exception(); // beyond the scope of this answer