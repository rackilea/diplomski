HMODULE jniModule = LoadLibrary(dllpath);
delete[] dllpath;
if (jniModule == NULL)
    throw gcnew System::ComponentModel::Win32Exception();
typedef int (JNICALL * JNI_CreateJavaVM)(JavaVM** jvm, JNIEnv** env, JavaVMInitArgs* initargs);
JNI_CreateJavaVM createJavaVM = (JNI_CreateJavaVM)GetProcAddress(jniModule, "JNI_CreateJavaVM");