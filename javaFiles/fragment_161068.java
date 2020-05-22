public int maxInArray() {
    int largest = arr[0];
    for (int i = 1; i < arr.length; i++) 
        if (arr[i] > largest) {
            largest = arr[i];
    }
    System.out.println("The max is " + largest);
    return largest;
}

public int minInArray() {
    int smallest = arr[0];
    for (int i = 1; i < arr.length; i++)
        if (arr[i] < smallest) {
            smallest = arr[i];
        }
    System.out.println("The mmin is " + smallest);
    return smallest;
}

public int rangeInArray() {
    int range = maxInArray() - minInArray() + 1;  // + 1 for "inclusive"
    System.out.println("The range is " + range);
    return range;
}