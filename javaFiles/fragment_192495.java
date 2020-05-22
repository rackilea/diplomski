LogData* l = /*...*/
jclass clCall = env->FindClass("LogDataJava$Call");
if (l->_callType == Call.UNDEFINED) {
    jfieldID fid = env->GetStaticFieldID(clCall , "UNDEFINED", "LLogDataJava$Call;"); 
} /* else ....*/

jobject callType = env->GetStaticObjectField(cl, fid);