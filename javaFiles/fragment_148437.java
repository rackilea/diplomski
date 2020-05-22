env->CallVoidMethod(javaClassObject, javaReceiveMethod, intParam, byteParam, objectParam);
if(env->ExceptionOccurred()) {
   // Print exception caused by CallVoidMethod
   env->ExceptionDescribe();
   env->ExceptionClear();
}