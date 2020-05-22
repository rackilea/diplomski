int maxIndex = -1, minIndex = -1;

for (int n = 0 ; n < numbers.length; n++) {
    if (numbers[n] < smallest) {
        smallest = numbers[n];
        minIndex = n;
    } 
    if (numbers[n] > largest) {
        largest = numbers[n];
        maxIndex = n;
    }      
}

System.out.println("Maximum number is " + numbers[maxIndex]+ " located in index " + maxIndex);
System.out.println("Minimum number is " + numbers[minIndex] + " located in index " + minIndex);