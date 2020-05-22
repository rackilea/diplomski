JNIEXPORT jboolean JNICALL Java_com_test_getData___3D( JNIEnv* pEnv, jclass cls, jdoubleArray dArray )
{
    jboolean isCopy1;
    jdouble* srcArrayElems = 
           pEnv->GetDoubleArrayElements(dArray, &isCopy1);
    jint n = pEnv->GetArrayLength(dArray);
    jboolean res = false;

    // here update srcArrayElems values, maybe set res to true

    if (isCopy1 == JNI_TRUE) {
       pEnv->ReleaseDoubleArrayElements(dArray, srcArrayElems, JNI_ABORT);
    }
    return res ;
}