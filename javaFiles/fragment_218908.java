void sendCount(int totalCount) {

jint jtotalCount = totalCount;
jobject dataObjectHandle = env->NewObject(dataClassHandle, dataUpdateHandle);
if (dataObjectHandle == NULL) LOGI("dataObjectHandle null");
LOGI("init CallVoidMethod");
env->CallStaticVoidMethod(dataClassHandle, dataUpdateHandle, jtotalCount);
}