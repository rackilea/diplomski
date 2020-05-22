jint JNI_OnLoad(JavaVM* vm, void* reserved)
{
    if (vm->GetEnv(reinterpret_cast<void**>(&env), JNI_VERSION_1_6) != JNI_OK) {
        return -1;
    }

    jclass dataClass = env->FindClass("com/example/crowdlogic/NativeManager");
    dataClassHandle = (jclass)env->NewGlobalRef(dataClass);
    dataUpdateHandle = env->GetStaticMethodID(dataClassHandle, "dataUpdate", "(I)V");
    return JNI_VERSION_1_6;
}