// The template bit here is just to pick the array dimensions from the array
// itself; you could also pass in a pointer and the dimensions. 
template<std::size_t OuterDim, std::size_t InnerDim>
jobjectArray to_java(JNIEnv *env, int (&arr)[OuterDim][InnerDim]) {
  // We allocate the int array first
  jintArray    inner = env->NewIntArray   (InnerDim);
  // to have an easy way to get its class when building the outer array
  jobjectArray outer = env->NewObjectArray(OuterDim, env->GetObjectClass(inner), 0);

  // Buffer to bring the integers in a format that JNI understands (jint
  // instead of int). This step is unnecessary if jint is just a typedef for
  // int, but on OP's platform this appears to not be the case.
  std::vector<jint> buffer;

  for(std::size_t i = 0; i < OuterDim; ++i) {
    // Put the data into the buffer, converting them to jint in the process
    buffer.assign(arr[i], arr[i] + InnerDim);

    // then fill that array with data from the input
    env->SetIntArrayRegion(inner, 0, InnerDim, &buffer[0]);
    // and put it into the outer array
    env->SetObjectArrayElement(outer, i, inner);

    if(i + 1 != OuterDim) {
      // if required, allocate a new inner array for the next iteration.
      inner = env->NewIntArray(InnerDim);
    }
  }

  return outer;
}