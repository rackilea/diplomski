//
//   VideoCapture::VideoCapture(const string& filename)
//

JNIEXPORT jlong JNICALL Java_org_opencv_highgui_VideoCapture_n_1VideoCapture__Ljava_lang_String_2
(JNIEnv* env, jclass, jstring filename);

JNIEXPORT jlong JNICALL Java_org_opencv_highgui_VideoCapture_n_1VideoCapture__Ljava_lang_String_2
(JNIEnv* env, jclass, jstring filename)
{
    try {
        LOGD("highgui::VideoCapture_n_1VideoCapture__Ljava_lang_String_2()");
        const char* jnamestr = env->GetStringUTFChars(filename, NULL);
        string stdFileName(jnamestr);
        VideoCapture* _retval_ = new VideoCapture( jnamestr );

        return (jlong) _retval_;
    } catch(cv::Exception e) {
        LOGD("highgui::VideoCapture_n_1VideoCapture__Ljava_lang_String_2() catched cv::Exception: %s", e.what());
        jclass je = env->FindClass("org/opencv/core/CvException");
        if(!je) je = env->FindClass("java/lang/Exception");
        env->ThrowNew(je, e.what());
        return 0;
    } catch (...) {
        LOGD("highgui::VideoCapture_n_1VideoCapture__Ljava_lang_String_2() catched unknown exception (...)");
        jclass je = env->FindClass("java/lang/Exception");
        env->ThrowNew(je, "Unknown exception in JNI code {highgui::VideoCapture_n_1VideoCapture__Ljava_lang_String_2()}");
        return 0;
    }
}