JNIEnv *env; 
state->activity->vm->AttachCurrentThread(&env, NULL); 

jclass envClass = env->FindClass("android/os/Environment");
jmethodID getExtStorageDirectoryMethod = env->GetStaticMethodID(envClass, "getExternalStorageDirectory",  "()Ljava/io/File;");
jobject extStorageFile = env->CallStaticObjectMethod(envClass, getExtStorageDirectoryMethod);

jclass fileClass = env->FindClass("java/io/File");
jmethodID getPathMethod = env->GetMethodID(fileClass, "getPath", "()Ljava/lang/String;");
jstring extStoragePath = env->CallObjectMethod(extStorageFile, getPathMethod);
const char* extStoragePathString = env->GetStringUTFChars(extStoragePath);

//use extStoragePathString

env->ReleaseStringUTFChars(extStoragePath, extStoragePathString);
state->activity->vm->DetachCurrentThread();