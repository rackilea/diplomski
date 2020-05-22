%module test

%{
#include "test.hh"
#include <algorithm>
%}


%typemap(jstype) std::array<double, 3> "Coord"
%typemap(javain) std::array<double, 3>, const std::array<double, 3>& "new double[]{$javainput.x, $javainput.y, $javainput.z}"
%typemap(jtype) std::array<double, 3> "double[]"
%typemap(jni) std::array<double, 3> "jdoubleArray"
%typemap(in) std::array<double, 3> {
  if (!$input || JCALL1(GetArrayLength, jenv, $input) != 3) {
    SWIG_JavaThrowException(jenv, SWIG_JavaIndexOutOfBoundsException, "incorrect array size");
    return $null;
  }
  double *arr = JCALL2(GetDoubleArrayElements, jenv, $input, NULL);
  std::copy_n(arr, 3, $1.begin());
  JCALL3(ReleaseDoubleArrayElements, jenv, $input, arr, JNI_ABORT);
}

%include "test.hh"