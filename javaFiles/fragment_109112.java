long[] digits = new long[12];
// Add the input to the array
...
for(int i=0;i<digits.length;i++){
  if(digits[i]%2==0){
        digits[i] *= 3;
  }
}