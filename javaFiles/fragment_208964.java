class nativebridge {
  ....
  static {
    System.loadLibrary("myCppApp"); 
    // notice that the lib prefix and .so sufix aren't part of the name
  }
}