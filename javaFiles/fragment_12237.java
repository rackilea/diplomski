vector <char*> vec;

jclass clazz = (*env).FindClass("java/util/ArrayList");
jobject obj = (*env).NewObject(clazz, (*env).GetMethodID(clazz, "<init>", "()V"));

for (int n=0;n<vec.size();n++)
{
   char* str = (char*) static_cast<char*>(vec[n]);

   jstring _str = (*env).NewStringUTF(str);

   (*env).CallVoidMethod(object, (*env).GetMethodID(clazz, "add", "(java/lang/Object)V"), _str);

}

return obj;