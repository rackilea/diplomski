JNIEXPORT jlong JNICALL Java_org_Create(
    JNIEnv *pEnv)
{
    pam_handle_t *pamh = createNew pam_handle somehow
    jlong result = (jlong) pamh;
    return result;
}

JNIEXPORT jint JNICALL Java_org_Blah_Blah_blah(
    JNIEnv *pEnv, jlong handle, jstring arg1,jstring arg2)
{
    pam_handle_t *pamh = (pam_handle_t*)handle;
 // ... Do rest of stuff
}