jstring metaStr = (*env)->NewStringUTF(env, "hello");

jobject array_element = (*env)->NewObject(
        env,
        event_class,
        ctor,
        (jint)4711, metaStr
);