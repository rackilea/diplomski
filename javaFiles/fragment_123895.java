jclass UBackTrackViewer_CLS = env->FindClass("com/example/alexies/objecttrackertest/UBackTrackViewer");
jclass TextView_CLS = env->FindClass("android/widget/TextView");
jmethodID setText_MID = env->GetMethodID(TextView_CLS, "setText", "(Ljava/lang/CharSequence;)V");

jfieldID mBlueGreenDistance_FID = env->GetFieldID(UBackTrackViewer_CLS, "mBlueGreenDistance", "Landroid/widget/TextView;");
…