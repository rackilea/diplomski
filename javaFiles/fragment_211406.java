// Sample C++ boolean variable you want to convert to Java:
bool someBoolValue = true;

// Get the Boolean class
jclass boolClass = env->FindClass("java/lang/Boolean");
// Find the constructor that takes a boolean (note not Boolean) parameter:
jmethodID boolInitMethod = env->GetMethodID(boolClass, "<init>", "(Z)V");

// Create the object
jobject boolObj = env->NewObject(boolClass,
                                 boolInitMethod,
                                 someBoolValue ? JNI_TRUE : JNI_FALSE);