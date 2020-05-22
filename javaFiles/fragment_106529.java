int digit = 0;
int sum = 0;
while(num > 0)
{
 digit = num % 10;
 sum += Math.pow(digit, 3);
num = num/10;
}