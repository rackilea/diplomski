%typemap(javaout) void* {
  long cPtr = $jnicall;
  Object result = null;
  if (type == type_t.TYPE1) {
    result = new type1(cPtr, $owner);
  }
  else if (type == type_t.TYPE2) {
    result = new type2(cPtr, $owner);
  }
  else if (type == type_t.TYPE3) {
    result = void2int(cPtr);
    // could also write "result = new Integer(void2int(cPtr));" explicitly here
  }
  else if (type == type_t.TYPE4) {
    result = void2str(cPtr);
  }

  return result;
}

%newobject fetch(type_t type);