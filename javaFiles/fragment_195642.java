//this is the function that shall be called from Java code
void JNICALL setWindowClosed(JNIEnv *env, jobject self, jboolean b){
    statusByte = (b==JNI_TRUE) ? true : false;
}

int main(){
JNIEnv* env;
JavaVM* jvm;
/*
create JavaVM and instantiate desired class

JNI_CreateJavaVM(...)
*/    
jclass cls = env->FindClass("ClassName");

//we have our class - now register our function
JNINativeMethod nativeMethod;
nativeMethod.name = "setWindowClosing"; //this is the corresponding name in Java
nativeMethod.signature = "(Z)V"; //parameter contains a boolean and returns void
nativeMethod.fnPtr = setWindowClosed; //pointer to our function
env->RegisterNatives(cls, &nativeMethod, 1); //register native method to Java
}