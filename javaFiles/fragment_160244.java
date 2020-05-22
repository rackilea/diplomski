jobject bb = env->NewDirectByteBuffer((void *) cStringValue, strlen(cStringValue));

jclass cls_Charset = env->FindClass("java/nio/charset/Charset");
jmethodID mid_Charset_forName = env->GetStaticMethodID(cls_Charset, "forName", "(Ljava/lang/String;)Ljava/nio/charset/Charset;");
jobject charset = env->CallStaticObjectMethod(cls_Charset, mid_Charset_forName, env->NewStringUTF("UTF-8"));

jmethodID mid_Charset_decode = env->GetMethodID(cls_Charset, "decode", "(Ljava/nio/ByteBuffer;)Ljava/nio/CharBuffer;");
jobject cb = env->CallObjectMethod(charset, mid_Charset_decode, bb);

jclass cls_CharBuffer = env->FindClass("java/nio/CharBuffer");
jmethodID mid_CharBuffer_toString = env->GetMethodID(cls_CharBuffer, "toString", "()Ljava/lang/String;");
jstring str = env->CallObjectMethod(cb, mid_CharBuffer_toString);

env->SetObjectField(jPosRec, myJniPosRec->_myJavaStringValue, str);