void XN_CALLBACK_TYPE PoseDetectionHandler(XnNodeHandle hNode, const XnChar* strPose, XnUserID user, void* pCookie)
{
    CallbackCookie* pCallback = (CallbackCookie*)pCookie;
    JNIEnvSupplier supplier;
    jstring jPose = supplier.GetEnv()->NewStringUTF(strPose);
    supplier.GetEnv()->CallVoidMethod(pCallback->obj, pCallback->mid, jPose, user);
    supplier.GetEnv()->ReleaseStringUTFChars(jPose, strPose);
}