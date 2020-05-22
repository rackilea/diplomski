jclass clazz = env->FindClass("com/myself/MyClass");
if (clazz == NULL)
    throw gcnew System::Exception();
jmethodID mid = env->GetStaticMethodID(clazz, "myStaticMethod", "<signature>");
if (mid == NULL)
    throw gcnew System::Exception();
<type> returnedValue = env->CallStatic<type>Method(clazz, mid, <arguments>);