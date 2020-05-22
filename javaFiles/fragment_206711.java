char[][] convertToTwoDimArray(String[] strArr){
  char[][] ret = new char[strArr.length][];
  for(int i=0; i<strArr.length; i++){
    ret[i] = strArr[i].toCharArray();
  }
  return ret;
}