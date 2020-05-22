if (VerifyFixClassname(clname) == JNI_TRUE) {
    /* slashes present in clname, use name b4 translation for exception */
    (*env)->GetStringUTFRegion(env, classname, 0, unicode_len, clname);
    JNU_ThrowClassNotFoundException(env, clname);
    goto done;
}

if (!VerifyClassname(clname, JNI_TRUE)) {  /* expects slashed name */
    JNU_ThrowClassNotFoundException(env, clname);
    goto done;
}