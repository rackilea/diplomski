int sLength = s.myLength();
if (sLength == 0) {
  return false; 
  // actually, it's for you to decide: 
  // technically each string begins with an empty string
}
if (sLength > this.mylength()) {
  return false;
}
for (int i = 0; i < sLength; i++) {
  if (lesCaracteres[i] != s.lesCaracteres[i]){
    return false;
  }
}
return true;