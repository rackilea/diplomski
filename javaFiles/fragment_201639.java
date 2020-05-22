static jclass rectClass = nulltr;
ststic jmethodID rectCtorID = 0;
if (rectCtorID == 0) {
    rectClass = env->NewGlobalRef(env->FindClass("org/opencv/core/Rect"));
    rectCtorID = env->GetMethodID(rectClass, "<init>", "(IIII)V");
}