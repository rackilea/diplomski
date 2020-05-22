public boolean isAmg(int num)
{
   int digit = 0;
   int sum = 0;
   int copyNum = num; //used to check at the last 
   while(num > 0)
   {
      digit = num % 10;
      sum += Math.pow(digit, 3);
      num = num / 10;
    }
    return sum == copyNum;
}