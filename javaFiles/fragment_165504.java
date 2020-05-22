JNIEnv* env;

JavaVM* jvm = cocos2d::JniHelper::getJavaVM();
if (NULL == jvm)
    CCLog("Failed to get the JavaVM");

jint ret = jvm->GetEnv((void**)&env, JNI_VERSION_1_4);
if (ret != JNI_OK)
    CCLog("Failed to get then JNIEnv");

jclass myClass = env->FindClass("org/cocos2dx/extbeatanni/ExtremeBeatAnnihilation");
if (!myClass)
    CCLog("Failed to find class ExtremeBeatAnnihilation");

jmethodID getObjectMethod = env->GetStaticMethodID(myClass, "getObject", "()Ljava/lang/Object;");
if(!getObjectMethod)
    CCLog("Failed to find method getObject");

jobject myInstance = env->CallStaticObjectMethod(myClass, getObjectMethod);
if(!myInstance)
    CCLog("Failed to get the current instance of the running activity");

jmethodID startupFileExploreMethod = env->GetMethodID(myClass, "startupFileExplore", "()V");
if (!startupFileExploreMethod)
    CCLog("Failed to find method startupFileExplore");

// call the java method within the ExtremeBeatAnnihilation activity that will start up file explore
env->CallNonvirtualVoidMethod(myInstance, myClass, startupFileExploreMethod);