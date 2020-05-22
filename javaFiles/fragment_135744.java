JavaVM * savedVM = NULL;
JNIEXPORT void JNICALL Java_NativeClass_addListener(JNIEnv *env, jobject obj_instance, jobject listener_instance) 
{
   env->GetJavaVM( &savedVM );
   //save listener_instance for use later
   saved_listener_instance = listener_instance;
}

void doSomething()
{
    //Get current thread JNIEnv
    JNIEnv * ENV;
    int stat = savedVM->GetEnv((void **)&ENV, JNI_VERSION_1_6);
    if (stat == JNI_EDETACHED)  //We are on a different thread, attach
        savedVM->AttachCurrentThread((void **) &ENV, NULL);
    if( ENV == NULL )
        return;  //Cant attach to java, bail

    //Get the Listener class reference
    jclass listenerClassRef = ENV->GetObjectClass( saved_listener_instance );

    //Use Listener class reference to load the eventOccurred method
    jmethodID listenerEventOccured = ENV->GetMethodID( listenerClassRef, "eventOccurred", "(LInfo;)V" );

    //Get Info class reference
    jclass infoClsRef = ENV->FindClass( "Info" );

    //Create Info class
    jobject info_instance = ENV->NewObject( infoClsRef, ..... );//For you to fill in with your arguments

    //invoke listener eventOccurred
    ENV->CallVoidMethod( saved_listener_instance, listenerEventOccured, info_instance );

    //Cleanup
    ENV->DeleteLocalRef( info_instance );
}