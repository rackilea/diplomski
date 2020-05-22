// Do this once per session, e.g. an __init__ 

JNI_CreateJavaVM(&jvm, &env, &vm_args); 

// When needed invoke Example.foo(int)
jclass cls =
env->FindClass("Example");  jmethodID
mid = env->GetStaticMethodID(cls,
"foo", "(I)V"); 
env->CallStaticVoidMethod(cls, mid,100);