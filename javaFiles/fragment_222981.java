if(x == 0 || y == 0 || (x > 0 ^ y > 0)){
  //zero+N or one pos, another neg = no problems
  return x+y;
}else if(x > 0){
  //both pos, can only overflow
  return Long.MAX_VALUE - x < y ? Long.MAX_VALUE : x+y;
}else{
  //both neg, can only underflow
  return Long.MIN_VALUE - x > y ? Long.MIN_VALUE : x+y;
}