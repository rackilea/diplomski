static jobjectArray make_row(JNIEnv *env, jsize count, const char* elements[])
{
    jclass stringClass = (*env)->FindClass(env, "java/lang/String");
    jobjectArray row = (*env)->NewObjectArray(env, count, stringClass, 0);
    jsize i;

    for (i = 0; i < count; ++i) {
        (*env)->SetObjectArrayElement(env, row, i, (*env)->NewStringUTF(env, elements[i]));
    }
    return row;
}

JNIEXPORT jobjectArray JNICALL Java_Main_getStringArrays(JNIEnv *env, jclass klass)
{
    const jsize NumColumns = 4;
    const jsize NumRows = 2;

    const char* beatles[] = { "John", "Paul", "George", "Ringo" };
    jobjectArray jbeatles = make_row(env, NumColumns, beatles);

    const char* turtles[] = { "Leonardo", "Raphael", "Michaelangelo", "Donatello" };
    jobjectArray jturtles = make_row(env, NumColumns, turtles);

    jobjectArray rows = (*env)->NewObjectArray(env, NumRows, (*env)->GetObjectClass(env, jbeatles), 0);

    (*env)->SetObjectArrayElement(env, rows, 0, jbeatles);
    (*env)->SetObjectArrayElement(env, rows, 1, jturtles);
    return rows;
}