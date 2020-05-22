JNIEXPORT jobject JNICALL Java_test_JNITest_callBitmap
(JNIEnv * env, jclass clazz, jint width, jint height) {
    // Get a reference to the class
    jclass poolc = env->FindClass("test/Pool");
    // get the field JNIPOOL
    jfieldID jnipoolFID = env->GetStaticFieldID(poolc, "JNIPOOL", "Ltest/Pool;");
    jobject jnipool = env->GetStaticObjectField(poolc, jnipoolFID);

    // Find the method "getBitmap", taking 2 ints, returning test.Bitmap
    jmethodID getBitmapMID = env->GetMethodID(poolc, "getBitmap", "(II)Ltest/Bitmap;");

    // Call the method.
    jobject result = env->CallObjectMethod(jnipool, getBitmapMID, width, height);

    return result;
}