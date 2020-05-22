JNIEXPORT void JNICALL Java_<package>_calculate(
       JNIEnv * env,
       jobject object,
       jfloatArray rgbObject,
       jfloat factor){
   if(rgbObject==NULL) return; // Check if incomming array is NULL-Pointer
   jfloat* rgb = (*env)->GetFloatArrayElements(env,rgbObject,0);
   if(rgb==NULL) return;

   rgb[0]=5; // Test, crash!

   (*env)->ReleaseFloatArrayElements(env,rgb,rgbObject,0);
   }