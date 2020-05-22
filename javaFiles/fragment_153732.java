JNIEnv *env;
JavaVM* lJavaVM = app->activity->vm;
app->activity->vm->AttachCurrentThread(&env, NULL);

jobject lNativeActivity = app->activity->clazz;
jclass intentClass = env->FindClass("android/content/Intent");
jstring actionString =env->NewStringUTF("Package Name. Class Name");
jmethodID newIntent = env->GetMethodID(intentClass, "<init>", "()V");
jobject intent = env->AllocObject(intentClass);
env->CallVoidMethod(intent, newIntent);
jmethodID setAction = env->GetMethodID(intentClass, "setAction","(Ljava/lang/String;)Landroid/content/Intent;");
env->CallObjectMethod(intent, setAction, actionString);
jclass activityClass = env->FindClass("android/app/Activity");
jmethodID startActivity = env->GetMethodID(activityClass,"startActivity", "(Landroid/content/Intent;)V");
jobject intentObject = env->NewObject(intentClass,newIntent);
env->CallVoidMethod(intentObject, setAction,actionString);
env->CallVoidMethod(lNativeActivity, startActivity, intentObject);
app->activity->vm->DetachCurrentThread();