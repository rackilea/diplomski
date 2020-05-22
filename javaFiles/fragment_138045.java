jclass date = env->FindClass("java/util/Date");
if (env->ExceptionCheck()){
  std::cout << "Fail:";
}
jmethodID dateTypeConstructor= env->GetMethodID(date, "<init>", "()V");
if(dateTypeConstructor == nullptr){
  std::cout << "Fail:";
}
jobject dateObjectStart = env->NewObject(date, dateTypeConstructor);
if(dateObjectStart  == nullptr){
  std::cout << "Fail:";
}
jmethodID getTime = env->GetMethodID(date, "getTime", "()J");
if(getTime == nullptr){
  std::cout << "Fail:";
}
jlong a = env->CallLongMethod(dateObjectStart, getTime);
std::cout << a << std::endl;