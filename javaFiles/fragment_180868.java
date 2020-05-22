public Object[] func_get_args(Object... argv) {
  int TheSize = 0;
  for (int i = 0; i<argv.length; i++) {
    if(argv[i]!= null && argv[i].getClass().isArray()) {
      Object[] OneArray = (Object [])argv[i];
      TheSize += OneArray.length;
    } else {
      TheSize += 1;
    }
  }
  Object[] NewArray = new Object[TheSize];
  int ThePos = 0;
  for (int i = 0; i<argv.length; i++) {
    if(argv[i]!= null && argv[i].getClass().isArray()) {
      Object[] OneArray = (Object [])argv[i];
      System.arraycopy(OneArray, 0, NewArray, ThePos, OneArray.length);
      ThePos += OneArray.length;
    } else {
      Object[] OneArray = {argv[i]};
      System.arraycopy(OneArray, 0, NewArray, ThePos, 1);
      ThePos += 1;
    }
  }
  return NewArray;
}