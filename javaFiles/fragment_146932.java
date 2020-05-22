%module test

%{
#include "test.h"
#include <assert.h>
%}

%rename("%(strip:[_])s") "";
%immutable _PROJECTDETAILS::infoType;
%ignore info; // Ignore the member
%ignore _PROJECTDETAILS_info; // Ignore the anonymous type
%javamethodmodifiers GetProjectDetails "private";
%rename(GetProjectDetailsImpl) GetProjectDetails;

%typemap(jni) char *_PROJECTDETAILS::itemList "jobjectArray";
%typemap(jtype) char *_PROJECTDETAILS::itemList "String[]";
%typemap(jstype) char *_PROJECTDETAILS::itemList "String[]";
%typemap(javaout) char *_PROJECTDETAILS::itemList {
  return $jnicall;
}
%typemap(out) char *_PROJECTDETAILS::itemList {
  if (!$1) return NULL; // This fixes a possible bug in my previous answer
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
  //free($1); // Iff you need to free the C function return value
}

%pragma(java) modulecode=%{
  public static PROJECTDETAILS GetProjectDetails(PROJECT p, int a) {
    PROJECTDETAILS out = new PROJECTDETAILS();
    final int ret = GetProjectDetailsImpl(p,a,out);
    if (0!=ret) {
      // assuming this is an error throw something
    }
    return out;
  }
%}

%extend _PROJECTDETAILS {
  const char *itemList const {
    if ($self->infoType != INFOTYPE_ITEMLIST) {
     // Throw a Java exception here instead? That is another question...
     return NULL;
    }
    return $self->info.itemList;
  }
  const char *projectName const {
    if ($self->infoType != INFOTYPE_PROJECTNAME) {
      // Throw exception?
      return NULL;
    }
    return $self->info.projectName;
  }
}

%include "test.h"