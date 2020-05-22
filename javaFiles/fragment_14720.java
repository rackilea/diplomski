jint Java_com_example_pjtest_get_time(JNIEnv *env)
{
     time_t ltime;
     time(&ltime);
    return ctime(&ltime);

}