// Parse String to Integer 
int sum = 0;
int digits = Integer.parseInt(firstTwoDigit);
while (digits != 0) {
 int lastdigit = digits % 10;
 sum += lastdigit;
 digits /= 10;
}
if(sum>0){
  // do your work
}else{
  // do your work
}