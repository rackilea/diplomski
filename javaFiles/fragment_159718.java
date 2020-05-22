void JNICALL Java_my_java_class_MyClass_myNativeMethod
  (JNIEnv* env, jobject, jobjectArray objectArray)
{
  QAndroidJniObject obj(env->GetObjectArrayElement(objectArray, 0));
  QAndroidJniObject jstr = obj.callObjectMethod<jstring>("getString");
  QString qtstr = jstr.toString();
}