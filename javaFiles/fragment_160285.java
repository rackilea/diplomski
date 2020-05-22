%module test

%typemap(jtype) int arr[ANY] "int[]"
%typemap(jstype) int arr[ANY] "int[]"
%typemap(jni) int arr[ANY] "jintArray"
%typemap(javain) int arr[ANY] "$javainput"
%typemap(in) int arr[ANY] {
  // check the size is compatible here also
  $1 = JCALL2(GetIntArrayElements, jenv, $input, 0);
}
%typemap(freearg) int arr[ANY] {
  if ($1) {
    JCALL3(ReleaseIntArrayElements, jenv, $input, $1, JNI_ABORT);
  }
}
%typemap(argout) int arr[ANY] {
  JCALL3(ReleaseIntArrayElements, jenv, $input, $1, 0);
  $1 = NULL;
}

%inline %{
void populate(int arr[100000]) {
  for (unsigned i = 0; i < 100000; ++i) {
    arr[i] = -i;
  }
}
%}