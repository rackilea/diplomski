public static int findMin(int[] numbers, int index) {
    if (index == numbers.length - 1) 
    {
        return numbers[index];
    }
    else
    {
        return Math.min(numbers[index], findMin(numbers, index + 1));
    }    
}