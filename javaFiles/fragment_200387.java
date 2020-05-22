public void setAge(int a) throws Exception {
  if (this.validAge(a))
    age =a ;
  else 
    throw new Exception("...")
}