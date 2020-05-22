JNIEXPORT jint JNICALL com_example_dorian_testapplication_PythonTest_PyRun_1SimpleString
  (JNIEnv *env, jclass jc, jstring js)
{
    char* cs = env->GetStringUTFChars(js, 0);
    std::string s = new std::string(cs);
    env->ReleaseStringUTFChars(env, js, cs);
    return PyRun_SimpleString(s.c_str());
}