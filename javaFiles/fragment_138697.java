// Note that this function does not return an array but a vector of vectors
// because 2-dimensional Java arrays need not be rectangular and have
// dynamic size. It is not generally practical to map them to C++ arrays.
std::vector<std::vector<int> > from_java(JNIEnv *env, jobjectArray arr) {
  // always on the lookout for null pointers. Everything we get from Java
  // can be null.
  jsize OuterDim = arr ? env->GetArrayLength(arr) : 0;
  std::vector<std::vector<int> > result(OuterDim);

  for(jsize i = 0; i < OuterDim; ++i) {
    jintArray inner = static_cast<jintArray>(env->GetObjectArrayElement(arr, i));

    // again: null pointer check
    if(inner) {
      // Get the inner array length here. It needn't be the same for all
      // inner arrays.
      jsize InnerDim = env->GetArrayLength(inner);
      result[i].resize(InnerDim);

      jint *data = env->GetIntArrayElements(inner, 0);
      std::copy(data, data + InnerDim, result[i].begin());
      env->ReleaseIntArrayElements(inner, data, 0);
    }
  }

  return result;
}