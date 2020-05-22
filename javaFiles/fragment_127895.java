JNIEXPORT void Java_ran_com_FirstActivity(JNIEnv *javaEnvironment, jobject self, jobjectArray stringArray) {

    int stringCount = javaEnvironment->GetArrayLength(stringArray);

    for (int i=0; i<stringCount; i++) {
            jstring string = (jstring) (javaEnvironment->GetObjectArrayElement(stringArray, 0));
            const char *rawString = javaEnvironment->GetStringUTFChars(string, JNI_FALSE);

            jstring istring = (jstring) (javaEnvironment->GetObjectArrayElement(stringArray, 1));
            const char *rawStringb = javaEnvironment->GetStringUTFChars(istring, JNI_FALSE);
            // I extracyed both string items to different chars before passing //to my methods...since jni only support passing two custom parameters
            example = new SuperpoweredExample(rawString, rawStringb);
            javaEnvironment->ReleaseStringUTFChars(string, rawString);
            javaEnvironment->ReleaseStringUTFChars(istring, rawStringb);
        }

}