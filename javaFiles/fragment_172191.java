JNIEXPORT jint JNICALL Java_MyClass_callNativeCode(::JNIEnv* env, jobject thisobject)
{
    // Find the required classes
    jclass thisclass = env->GetObjectClass(thisobject);
    jclass matclass = env->FindClass("org/opencv/core/Mat");

    // Get methods and fields
    jmethodID getPtrMethod = env->GetMethodID(matclass, "getNativeObjAddr", "()J");
    jfieldID mrgbafieldid = env->GetFieldID(thisclass, "mRgba", "Lorg/opencv/core/Mat;");
    jfieldID bufimgsfieldid = env->GetFieldID(thisclass, "bufImgs", "[Lorg/opencv/core/Mat;");

    // Let's start: Get the fields
    jobject mrgba = env->GetObjectField(thisobject, mrgbafieldid);
    jobjectArray bufimgsArray = (jobjectArray)env->GetObjectField(thisobject, bufimgsfieldid);

    // Convert the array
    cv::Mat nativeBufImgs[7];
    for (int i = 0; i < 7; i++)
        nativeBufImgs[i] = *(cv::Mat*)env->CallLongMethod(env->GetObjectArrayElement(bufimgsArray, i), getPtrMethod);

    // Get the address for mRgba
    cv::Mat* mrgbaptr = (cv::Mat*)env->CallLongMethod(mrgba, getPtrMethod);

    // We're done! Call the method and return!
    return nativeCode(mrgbaptr, nativeBufImgs);
}