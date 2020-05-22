static jint floatToRawBits(JNIEnv* env, jclass clazz, jfloat val)
{
    Float   f;
    f.f = val;
    return f.bits;
}

static jfloat intBitsToFloat(JNIEnv* env, jclass clazz, jint val)
{
    Float   f;
    f.bits = val;
    return f.f;
}