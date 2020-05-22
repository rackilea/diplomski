JNIEXPORT jobject JNICALL
Java_com_company_pos_DbHelper_getWritableSqlite(JNIEnv *e, jobject obj) {
    JNIEnv *env = getEnv();
    if (env == NULL || obj == NULL) {
        return NULL;
    }

    // Error in here when calling getWritableDatabase from net/sqlcipher/database/SQLiteOpenHelper
    _objGetWritableDatabase = env->CallObjectMethod(_clsSQLiteOpenHelper, _midGetWritableDatabase, env->NewStringUTF("MyPassword"));  
    if (_objGetWritableDatabase == NULL || tryCatch()) {
        return NULL; // Program stop in here.
    }
    return _objGetWritableDatabase;
}