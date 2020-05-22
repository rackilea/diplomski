JNIEXPORT jint JNICALL Java_example_package_MyFunkyJNIClass_nativeExecuteFunction(JNIEnv *env, jobject this, jint CallType, jobject Payload)
{
    // **** JNI Specific declarations for mapping ****
    jclass          cls, cls2, cls3;
    jmethodID       mid, mid2;
    jfieldID        fid;
    jint            rc = 0;
    jsize           js = 0;
    jbyte           jb;
    jobject         jobj, jobj2, jro;
    jobjectArray    jobjArray, jobjArray2;

    _svc_results    results;

    switch ((int)CallType)
    {
    case CALLTYPE1:       // 1
        DEBUG_PRINT("JNI Call Type 1 in progress...\n");
        // JNI mapping happens here
        stat = DoSomethingInC(args, &results);

        // Map from C structure (_statblk) to Java object
        if (stat == SUCCESS) {
            DEBUG_PRINT("\tMapping from C structure (_statblk) to Java object\n");

            cls  = (*env)->FindClass(env, "Lexample/package/statusBlock;");
            mid  = (*env)->GetMethodID(env, cls, "<init>", "()V"); if (mid == NULL) return -1;
            jro  = (*env)->NewObject(env, cls, mid); if (jro == NULL) return -1;

            fid  = (*env)->GetFieldID(env, cls, "errcode","I"); if (fid == NULL) return -1;
            (*env)->SetIntField(env, jro, fid, (jint)results.statblk.errcode);
            DEBUG_PRINT("\t\tMapped errcode: %d\n",results.statblk.errcode);

            fid  = (*env)->GetFieldID(env, cls, "errref","I"); if (fid == NULL) return -1;
            (*env)->SetIntField(env, jro, fid, (jint)results.statblk.errref);
            DEBUG_PRINT("\t\tMapped errref: %d\n",results.statblk.errref);

            fid  = (*env)->GetFieldID(env, cls, "errmsg","[B"); if (fid == NULL) return -1;
            jobj = (*env)->NewByteArray(env, MAX_ERR);
            (*env)->SetByteArrayRegion(env, (jbyteArray)jobj, 0, MAX_ERR, (jbyte*)results.statblk.errmsg);
            (*env)->SetObjectField(env, jro, fid, jobj);
            (*env)->DeleteLocalRef(env, jobj);
            DEBUG_PRINT("\t\tMapped errmsg: %s\n",results.statblk.errmsg);

            fid  = (*env)->GetFieldID(env, cls, "TmidArray","[I"); if (fid == NULL) return -1;
            jobj = (*env)->NewIntArray(env, (jsize)results.statblk.TmidArray.TmidArray_len);
            (*env)->SetIntArrayRegion(env, (jintArray)jobj, 0, 
                                      (jsize)results.statblk.TmidArray.TmidArray_len,
                                      (jint*)results.statblk.TmidArray.TmidArray_val);
            (*env)->SetObjectField(env, jro, fid, jobj);
            (*env)->DeleteLocalRef(env, jobj);
            DEBUG_PRINT("\t\tMapped TmidArray\n");

            fid  = (*env)->GetFieldID(env, cls, "evt_id","I"); if (fid == NULL) return -1;
            (*env)->SetIntField(env, jro, fid, (jint)results.statblk.evt_id);
            DEBUG_PRINT("\t\tMapped evt_id: %d\n",results.statblk.evt_id);

            cls  = (*env)->GetObjectClass(env, this);
            fid  = (*env)->GetFieldID(env, cls, "response","Ljava/lang/Object;"); if (fid == NULL) return -1;
            (*env)->SetObjectField(env, this, fid, jro);

            DEBUG_PRINT("\tMapping from C structure (_statblk) to Java object - DONE\n");
        } else {
            DEBUG_PRINT("JNI Call Type 1 in progress... Returning Error: %d\n", stat);
            return (jint)stat;
        }

        /* Free our native memory */
        cls  = (*env)->GetObjectClass(env, Payload);
        fid  = (*env)->GetFieldID(env, cls, "message","Ljava/lang/String;"); if (fid == NULL) return -1;
        jobj = (*env)->GetObjectField(env, Payload, fid);
        GPS_Free(results.statblk.TmidArray.TmidArray_val);
        GPS_Free(results.statblk.ErrorArray.ErrorArray_val);
        DEBUG_PRINT("JNI RTP Posting in progress... DONE\n");
        break;
    case PING:          // 2
        DEBUG_PRINT("No Java to C mapping required\n");
        DEBUG_PRINT("JNI Ping in progress...\n");
        stat = doPing();

        DEBUG_PRINT("No C to Java mapping required\n");
        // Stop null pointer exception if client tries to access the response object.
        cls  = (*env)->FindClass(env, "Lexample/package/EmptySerializableClass;");
        mid  = (*env)->GetMethodID(env, cls, "<init>", "()V"); if (mid == NULL) return -1;
        jro  = (*env)->NewObject(env, cls, mid); if (jro == NULL) return -1;

        cls  = (*env)->GetObjectClass(env, this);
        fid  = (*env)->GetFieldID(env, cls, "response","Ljava/lang/Object;"); if (fid == NULL) return -1;
        (*env)->SetObjectField(env, this, fid, jro);
        DEBUG_PRINT("JNI Ping in progress... DONE\n");

        return (jint)rpc_stat;
        break;
    default:
        fprintf(stderr,"Unknown call type\n");
        rc = -1;
        break;
    }

    return rc;
}