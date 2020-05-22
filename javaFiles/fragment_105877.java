/*
 * Class:     HumanController
 * Method:    getAgeOfHuman
 * Signature: (LHumanBean;)I
 */
JNIEXPORT jint JNICALL Java_HumanController_getAgeOfHuman(JNIEnv *env, jclass obj, jobject objarg)
{
    std::cout << "-------------------------Java_HumanController_getAgeOfHuman---------------------------" << std::endl;

    if (!objarg) {
        std::cout << "objarg is null!" << std::endl;
        return -1; // or env->Throw() an exception...
    }

    jclass cls = env->GetObjectClass(objarg);
    // TODO: verify that objarg is really an instance of the
    // "at.xxxx.calculatorhuman.HumanBean" class before doing
    // anything with it...

    /////////////////////////////////
    jfieldID fidName = env->GetFieldID(cls, "name", "Ljava/lang/String;");
    std::cout << "First Line Finished  - jfieldID = " << fidName << std::endl;
    if (!fidName) {
        std::cout << "Could not find objarg.name field!" << std::endl;
        return -1; // or env->Throw() an exception...
    }

    jstring nameStringJNI = (jstring) env->GetObjectField(objarg, fidName); // <-- use objarg, not cls!
    std::cout << "Second Line Finished - jstring = " << nameStringJNI << std::endl;
    if (!nameStringJNI) {
        std::cout << "Could not get pointer to objarg.name field!" << std::endl;
        return -1; // or env->Throw() an exception...
    }

    // NOTE: Java uses *modified* UTF-8! Consider using env->GetStringChars()
    // with std::wstring instead... 
    const char* raw = env->GetStringUTFChars(nameStringJNI, NULL);
    std::cout << "Third Line Finished - raw = " << (const void*)raw << std::endl;
    if (!raw) {
        std::cout << "Could not get pointer to objarg.name content!" << std::endl;
        return -1; // or env->Throw() an exception...
    }

    std::string str(raw); // <-- can't construct std::string with a NULL pointer!
    env->ReleaseStringUTFChars(nameStringJNI, raw); // <-- avoid a memory leak!
    std::cout << "Fourth Line Finished - str = " << str << endl;
    std::cout << "Java_HumanController_getAgeOfHuman c++ Name " << str << endl;
    /////////////////////////////////

    Human humanMirror = createHuman(str, age, gehaltInt, gehaltDouble);
    return humanMirror.alter;
}