int[] numbers= numbers to be reversed;
reverseSum=0;
for(int i=0;i<numbers.length;i++){
    reverseSum+= reverse(numbers[i]);
}
...

public int reverse(int number){
     while( number >0)
    {
        reverse = reverse * 10;
        reverse = reverse + number%10;
        number = number/10;
    }
    return reverse;
}