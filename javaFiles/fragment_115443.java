int size = env->GetArrayLength(stringArrays);

for (int i=0; i < size; ++i) 
{
    jstring string = env->GetObjectArrayElement(stringArrays, i);
    const char* mayarray = env->GetStringUTFChars(string, 0);
    .... do some work or copy it to a c++ array of char*....
    env->ReleaseStringUTFChars(string, myarray);
    env->DeleteLocalRef(string);
}