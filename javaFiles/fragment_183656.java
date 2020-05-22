JNIEXPORT jlong JNICALL Java_JNITest_processImage(JNIEnv *env, jclass clazz, jstring svgData) {

    char *str = (*env)->GetStringUTFChars(env, svgData, NULL);
    void* mapData;
    process_image(str, &mapData);
    (*env)->ReleaseStringUTFChars(env, svgData, str);
    return (jlong)mapData;
}

JNIEXPORT jint JNICALL Java_JNITest_processMapData(JNIEnv *env, jlcass clazz, jlong mapData) {
    return process_mapData((void *)mapData);
}