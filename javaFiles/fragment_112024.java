%module num

%{
#include <vector>
#include <stdexcept>

std::vector<double> testVec() {
  return std::vector<double>(10,1.0);
}

std::vector<std::vector<double> > testMat() {
  return std::vector<std::vector<double> >(10, testVec());
}
%}

%pragma(java) jniclasscode=%{
  static {
    try {
        System.loadLibrary("num");
    } catch (UnsatisfiedLinkError e) {
      System.err.println("Native code library failed to load. \n" + e);
      System.exit(1);
    }
  }
%}