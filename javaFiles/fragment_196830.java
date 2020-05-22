JNIEXPORT void JNICALL Java_Main_sort(JNIEnv *env, jclass _, jobjectArray objArr) {
    jsize len = (*env)->GetArrayLength(env, objArr);

    for(int i = 0; i < len; i++) {
        jintArray arr = (jintArray) (*env)->GetObjectArrayElement(env, objArr, i);
        jsize innerLen = (*env)->GetArrayLength(env, arr);
        jint* vals = (*env)->GetIntArrayElements(env, arr, NULL);            

        /* make changes to 'vals' */

        (*env)->ReleaseIntArrayElements(env, arr, vals, JNI_COMMIT);
        (*env)->DeleteLocalRef(env, arr);
    }
}