%module test

%{
#include "test.h"
#include <assert.h>
%}

// See part 2 for discusson of these
%rename("%(strip:[_])s") "";
%immutable _PROJECTDETAILS::infoType;

%typemap(jni) char * _PROJECTDETAILS::_PROJECTDETAILS_info::itemList "jobjectArray";
%typemap(jtype) char * _PROJECTDETAILS::_PROJECTDETAILS_info::itemList "String[]";
%typemap(jstype) char * _PROJECTDETAILS::_PROJECTDETAILS_info::itemList "String[]";
%typemap(javaout) char * _PROJECTDETAILS::_PROJECTDETAILS_info::itemList {
  return $jnicall;
}
%typemap(out) char * _PROJECTDETAILS::_PROJECTDETAILS_info::itemList {
  size_t count = 0;
  const char *pos = $1;
  while (*pos) {
    while (*pos++); // SKIP
    ++count;
  }
  $result = JCALL3(NewObjectArray, jenv, count, JCALL1(FindClass, jenv, "java/lang/String"), NULL);
  pos = $1;
  size_t idx = 0;
  while (*pos) {
    jobject str = JCALL1(NewStringUTF, jenv, pos);
    assert(idx<count);
    JCALL3(SetObjectArrayElement, jenv, $result, idx++, str);
    while (*pos++); // SKIP
  }
  //free($1); // Iff you need to free the C function's return value
}

%include "test.h"