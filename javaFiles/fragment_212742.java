public void invoker(){
    String x = "kk";
    String y = nits;
    x = getAppendedString(x,y);

}
public String getAppendedString(String a, String b){
     a = a.append(b); // as Strings are non mutable hence this is not changed on the original passed object. The assignment of a also does not make any difference as it's local variable.
  return a
}