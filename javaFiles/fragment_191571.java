JNIEXPORT int JNICALL Java_recipeNo038_PassHashMap_displayHashMap
  (JNIEnv *env, jclass obj, jobjectArray keys, jobjectArray values) {

  /* We need to get array size. There is strong assumption that
     keys and values have the same length
  */
  int arraySize = (*env)->GetArrayLength(env, keys);

  /* For all elements in array, we will convert them to C based strings
  */
  for (int i=0; i < arraySize; i++)
  {
    /* First, we take key */
    jstring objKey = (*env)->GetObjectArrayElement(env, keys, i);
    const char* c_string_key = (*env)->GetStringUTFChars(env, objKey, 0);

    /* Then, we take the value value  */
    jobject objValue = (*env)->GetObjectArrayElement(env, values, i);
    const char* c_string_value = (*env)->GetStringUTFChars(env, objValue, 0);

    /* And we print some info for user */
    printf("[key, value] = [%s, %s]\n", c_string_key, c_string_value);

    /* Make sure to release stuff */
    (*env)->ReleaseStringUTFChars(env, objKey, c_string_key);
    (*env)->DeleteLocalRef(env, objKey);

    (*env)->ReleaseStringUTFChars(env, objValue, c_string_value);
    (*env)->DeleteLocalRef(env, objValue);
  }

  return 0;

}