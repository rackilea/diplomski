// Replace

    sc_class = (*env)->FindClass(env, "com/my/package/StateController");

// With

    sc_class = (*env)->NewGlobalRef(
        env, 
        (*env)->FindClass(
            env, 
            "com/my/package/StateController"
        )
    );

// Later when you are done with the class reference, run this to free it.

    (*env)->DeleteGlobalRef(env, sc_class);