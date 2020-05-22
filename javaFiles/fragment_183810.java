static jvmtiIterationControl JNICALL
HeapObjectCallback(jlong class_tag, jlong size, jlong* tag_ptr, void* user_data) {
    *tag_ptr = 1;
    return JVMTI_ITERATION_CONTINUE;
}

JNIEXPORT void JNICALL
Java_Test_iterateInstances(JNIEnv* env, jclass ignored, jclass targetClass) {
    JavaVM* vm;
    env->GetJavaVM(&vm);

    jvmtiEnv* jvmti;
    vm->GetEnv((void**)&jvmti, JVMTI_VERSION_1_0);

    jvmtiCapabilities capabilities = {0};
    capabilities.can_tag_objects = 1;
    jvmti->AddCapabilities(&capabilities);

    jvmti->IterateOverInstancesOfClass(targetClass, JVMTI_HEAP_OBJECT_EITHER,
                                       HeapObjectCallback, NULL);

    jlong tag = 1;
    jint count;
    jobject* instances;
    jvmti->GetObjectsWithTags(1, &tag, &count, &instances, NULL);

    printf("Found %d objects with tag\n", count);

    jvmti->Deallocate((unsigned char*)instances);
}