//save the largest number
int largest = 0;

//loop over every possible product of numbers from 100-999
for (int i = 999; i >= 100; i--) {
 for (int j = i; j >= 100; j--) {
  int curr = i * j;

  //if the current number is a palindrome and is greater than the last found largest
  if (isPalindrome(curr) && curr > largest) {

   //save it as the new largest found number
   largest = curr;
  }
 }
}