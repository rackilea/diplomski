public static int findSmallest( final int[] numbers, final String toReturn ) 
{
    int smallest = numbers[0];
    for (int i = 0; i < numbers.length; i++) {             
        if (numbers[i] <= smallest) {
            smallest = numbers[i];
        }
    }
    System.out.println(smallest); 
    return smallest;
}