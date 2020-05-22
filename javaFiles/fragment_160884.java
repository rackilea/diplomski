int first_lo = 1, first_hi = 3000; // 1/2 chance to choose a number in [first_lo, first_hi]
int second_lo = 3001, second_hi = 7000; // 1/6 chance to choose a number in [second_lo, second_hi] 
int third_lo = 7001, third_hi = 10000;// 1/3 chance to choose a number in [third_lo, third_hi] 
int second
int temp = random(0,5);
if (temp <= 2) {
  return random(first_lo,first_hi);
} else if (temp <= 3) {
 return random(second_lo,second_hi);
} else  {
 return random(third_lo,third_hi);
}