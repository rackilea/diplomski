public int compareTo(Object o) {        
  int ret = other.getlength() - this.getlength();
  if ( ret == 0 ) {
    ret = other.getVal() - this.getVal();
  }
  return ret;
}