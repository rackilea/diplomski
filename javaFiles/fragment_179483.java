jclass clazz = env->FindClass("JFunctionArgs");
jmethodID ctor = env->GetMethodID(clazz, "<init>", "()V");
jobject obj = env->NewObject(clazz, ctor);

jfieldID urlField = env->GetFieldID(clazz, "url", "Ljava/lang/String;");
env->SetObjectField(obj, urlField, env->NewString(functionArgs.url));