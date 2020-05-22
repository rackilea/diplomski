JNIEXPORT void JNICALL
java_com_example_my_project_native_1setFooArray(JNIEnv *env, jobject instance, jobjectArray fooArray, jint arraySize) {

    std::vector<Foocpp> cfooArray;

    jfieldID fidA;
    jfieldID fidB;

    for (jint i = 0; i < arraySize; i++) {
        jobject jfoo = env->GetObjectArrayElement(fooArray, i);
        jclass cfoo = env->GetObjectClass(jfoo);

        fidA = env->getFieldID(cfoo, "A", "I");
        fidB = env->GetFieldID(cfoo, "B", "I");
        jint A = env->GetIntField(cfoo, fidA);
        jint B = env->GetIntField(cfoo, fidB);

        const Foocpp foo = Foocpp(A, B);
        cfooArray.push_back(foo);
    }

    class->setFooArray(cfooArray);