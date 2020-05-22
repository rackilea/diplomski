static void write_output(struct output_state *s) {
    int i;
    jint sample;
    for (i = 0; i < 2 * s->result_len; i += 2) {
        sample = (s->result[i] << 8) + s->result[i+1];
        (*(s->env))->CallVoidMethod(s->env, s->tunerOut, s->writeShort, sample);
    }
}

static void *output_thread_fn(void *arg)
{
    struct output_state *s = arg;
    (*(s->jvm))->AttachCurrentThread(s->jvm, &(s->env), NULL);
    jclass clsSelf = (*(s->env))->GetObjectClass(s->env, s->self);
    jfieldID fTunerOut = (*(s->env))->GetFieldID(s->env, clsSelf, "tunerOut", "Ljava/io/DataOutputStream;");
    s->tunerOut = (*(s->env))->GetObjectField(s->env, s->self, fTunerOut);
    jclass cls = (*(s->env))->GetObjectClass(s->env, s->tunerOut);
    s->writeShort = (*(s->env))->GetMethodID(s->env, cls, "writeShort", "(I)V");
    while (!do_exit) {
        // use timedwait and pad out under runs
        safe_cond_wait(&s->ready, &s->ready_m);
        pthread_rwlock_rdlock(&s->rw); //sync access to s with producer thread
        write_output(s);
        pthread_rwlock_unlock(&s->rw);
    }
    (*(s->jvm))->DetachCurrentThread(s->jvm);
    return 0;
}

JNIEXPORT jboolean JNICALL Java_eu_jacquet80_rds_input_SdrGroupReader_open
  (JNIEnv *env, jobject self) {
    jclass clsSelf = (*env)->GetObjectClass(env, self);

    if (!writeShortID || !cls)
        return 0;

    output.self = (*env)->NewGlobalRef(env, self);
    (*env)->GetJavaVM(env, &(output.jvm));

    (*env)->CallVoidMethod(env, tunerOut, writeShortID, 0); // just for testing

    pthread_create(&controller.thread, NULL, controller_thread_fn, (void *)(&controller));
    usleep(100000);
    pthread_create(&output.thread, NULL, output_thread_fn, (void *)(&output));
    pthread_create(&demod.thread, NULL, demod_thread_fn, (void *)(&demod));
    pthread_create(&dongle.thread, NULL, dongle_thread_fn, (void *)(&dongle));

    return 1;
}