fid = j.GetFieldID( jc, UTF8_SECPARM, SIG_SECPARM );
if ( JNI_TRUE == j.ExceptionCheck() ) {
    j.ExceptionClear();
    return;
}
... continue with fid ...