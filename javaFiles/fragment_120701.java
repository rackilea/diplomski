JNIEXPORT void JNICALL Java_*mypackage*_sign(JNIEnv* env, jbytearray input, jint ilen, jbytearray output, jint olen) {
  char* pinput = (*env)->GetByteArrayElements(env, input, NULL);
  char* poutput = (*env)->GetByteArrayElements(env, output, NULL);

  sign(pinput, ilen, poutput, olen);

  (*env)->ReleaseByteArrayElements(env, input, pinput, 0);
  (*env)->ReleaseByteArrayElements(env, output, poutput, 0);
}