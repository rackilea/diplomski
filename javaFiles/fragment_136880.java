// parameter
jobject YourJObjectRepresentingArrayList;

// I suppose you have the JNIEnv somehow
JNIEnv* env;

// use the Array list
ArrayList_class       = env->FindClass( "java/util/ArrayList" );

    // to conver jobject to jstring
    jmethodID caster = env->GetMethodID(ArrayList_class, "toString", "()Ljava/lang/String;");

// get two methods
Get_method            = env->GetMethodID( ArrayList_class, "get", "(I)Ljava/lang/Object" );
Size_method           = env->GetMethodID( ArrayList_class, "size", "()I" );

// call java.lang.ArrayList.get()
int NumElts = env->CallIntMethod(YourJObjectRepresentingArrayList, ArrayList_class, Size_method);

// allocate output array
LPWSTR* Out = new LPWSTR[NumElts];

// fetch all the items
for(int i = 0 ; i < NumElts ; i++)
{
    // call java.lang.ArrayList.get(int index) method
    // Not sure about the parameter passing here
    jobject Tmp = env->CallObjectMethod(YourJObjectRepresentingArrayList, Get_method, i);

    jstring Str = (jstring)env->CallObjectMethod(Tmp, caster);

    // get the length
    int StrLen = env->GetStringLength(env, Str);

    Out[i] = new wchar_t[StrLen];

    const char* SourceUTF = env->GetStringChars(env, Str);

    // store the string - not sure about UTF-16/UTF-8 here. It is OS-dependant.
    // MultiByteToWideChar or iconv on POSIX
    ConvertUTF8ToWChar(Out[i], SourceUTF);

    env->ReleaseStringUTFChars(s, SourceUTF);
}

// done