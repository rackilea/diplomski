JNIEXPORT void JNICALL Java_Foo_use
  (JNIEnv *, jobject, jlong handle) {
   auto iter = handles.find(handle);
   if (iter != handles.end()) {
       Foo* ptr = iter->second;
       // use Foo* here
   }
}