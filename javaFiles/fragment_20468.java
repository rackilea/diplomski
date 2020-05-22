...
WPARAM param = kbhook->vkCode;

JNIEnv *env;
jint rs = (*javaVM)->AttachCurrentThread(javaVM, (void**)&env, NULL);
if (rs != JNI_OK) {
    return NULL; // Or something appropriate...
}
...

    case VK_ESCAPE:
        printf("Escape pressed !\n");
        jstring message = (*env)->NewStringUTF(env, "1B");
        (*env)->CallVoidMethod(env, callbackObject, callbackMethod, message);
        break;
...