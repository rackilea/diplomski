/* Get objarg's class - objarg is the one we pass from
     Java */
  jclass clsSet = (*env)->GetObjectClass(env, objarg);

  /* Use javap to get propper descriptor
     > javap -s -p java.util.Set | grep -A 1 toArray
         public abstract java.lang.Object[] toArray();
           descriptor: ()[Ljava/lang/Object;
  */

  jmethodID midToArray =
    (*env)->GetMethodID(env, clsSet, "toArray", "()[Ljava/lang/Object;");

  /* We have to make sure that method exists */
  if (midToArray == NULL) {
    return -1; /* method not found */
  }

  /* Once we have method, we can call "toArray" and this way
     get array of all keys */
  jobjectArray arrayOfElements = (*env)->CallObjectMethod(env, objarg, midToArray);

  /* We will iterate over the array so we can get value for each key */
  int arraySize = (*env)->GetArrayLength(env, arrayOfElements);

  /* We want to go over all elements (all keys) */
  for (int i=0; i < arraySize; i++)
  {
    /* First, we need to get key value from array of all keys */
    jstring obj = (*env)->GetObjectArrayElement(env, arrayOfElements, i);
    const char* c_string = (*env)->GetStringUTFChars(env, obj, 0);

    /* We can print values passed to C from Java */
    printf("[value] = [%s]\n", c_string);

    /* Make sure to release local stuff */
    (*env)->ReleaseStringUTFChars(env, obj, c_string);

  }