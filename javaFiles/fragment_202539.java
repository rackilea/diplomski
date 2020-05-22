// Load the class
jclass jclass_JCV = env->FindClass(env, "my.package.JC_VerificationCandidate");

jfieldID fid_enrollmentID = env->GetFieldID(env, jclass_JCV, "enrollmentID" , "Ljava/lang/String;");

// Access the first element in the jVerificationCandList array 
jobject jc_v = env->GetObjectArrayElement(env, jVerificationCandList, 0);

// get reference to the string 
jstring jstr = (jstring) env->GetObjectField(env, jc_v, enrollmentID);

// Convert jstring to native string
const char *nativeString = env->GetStringUTFChars(env, jstr, 0);