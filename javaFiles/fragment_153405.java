int number = 10;
jmethodID initial = env->GetMethodID(Simulator,"initialize", "(Ljava/util/Date;Ljava/util/Date;I)V");
if (env->ExceptionCheck()){
  cout << "Fail:";
}
jclass dateType = env->FindClass("Ljava/util/Date;");
if(dateType == nullptr){
  cout << "Fail:";
}
jmethodID dateTypeConstructor= env->GetMethodID(dateType, "<init>", "(Ljava/lang/String;)V");
if(constructor == nullptr){
  cout << "Fail:";
}
jstring constructorString1 = env->NewStringUTF("2014/05/21T00:00:00");
jobject dateObject1 = env->NewObject(dateType , dateTypeConstructor, constructorString1);
if(dateObject1  == nullptr)
  cout << "Fail:";
}
jstring constructorString2 = env->NewStringUTF("2014/05/21T23:59:59");
jobject dateObject2 = env->NewObject(dateType , dateTypeConstructor, constructorString2);
if(dateObject2  == nullptr)
  cout << "Fail:";
}
env->CallVoidMethod(Simulation, initial, dateObject1, dateObject2, number);