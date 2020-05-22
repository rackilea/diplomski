jint len = env->GetArrayLength(myIntArray);
jint *elements = env->GetPrimitiveArrayCritical(myIntArray, NULL);

// Use elements...

env->ReleasePrimitiveArrayCritical(myIntArray, elements, 0);