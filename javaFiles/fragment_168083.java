JNIEXPORT jobject JNICALL
Java_com_company_pos_DbHelper_getWritableSqlite(JNIEnv *e, jobject obj) {
    JNIEnv *env = getEnv();
    if (env == NULL || obj == NULL) {
        return NULL;
    }

    _objGetWritableDatabase = env->CallObjectMethod(obj, _midGetWritableDatabase, env->NewStringUTF("MyPassword"));  
    if (_objGetWritableDatabase == NULL || tryCatch()) {
        return NULL;
    }
    return _objGetWritableDatabase;
}