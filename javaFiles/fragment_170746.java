public double summation(int intN){
  if(intN == 0)
    return dbSum;
  else {
    return ((3.0*intX)-1)/(2.0*(intX+1)) + summation(intN - 1);
  }
}