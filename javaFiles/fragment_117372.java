// You should not store a reference to the Java array as a global variable.
// The reference is only valid between the Get/ReleaseFloatArrayElements calls
// Since valuesf is assigned the same reference to the Java array,
// the same advice also applies to it
// jfloat* valuesjf = NULL;
// float* valuesf = NULL;

void 
Java_Grids_Grid5_Update(JNIEnv* env,
                         jobject thiz,
                         jfloatArray values,
                         jint l, jint, m, jint n) {

  jfloat* valuesjf = (*env)->GetFloatArrayElements(env,values,NULL);
  float* valuesf = valuesjf;

  int x, y, z;
  int i = (m * n * z) + (n * y) + x;
  valuesf[0]=121+valuesf[i]; //do some calculations

  (*env)->ReleaseFloatArrayElements(env, values, valuesjf, JNI_ABORT);

}