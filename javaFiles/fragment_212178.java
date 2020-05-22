public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    int[] numList = {983, 235, 92, 118, 79, 203, 199};

    System.out.println("Enter the key: ");
    int key = input.nextInt();

    System.out.println("\nThe arrays: ");
    printArray(numList);

    if(searchKey(numList, key)) 
        System.out.println(key + " is found in the array");
     else 
        System.out.println(key + " is not found in the array");

    input.close();
}

public static boolean searchKey(int[] numList, int key) {

    for (int i = 0; i < numList.length; i++) {
        if(key == numList[i])
            return true; // If anywhere key is found, it will return true
    }
    return false;  // After traversing whole list if key is not found, then it will return false
}

public static void printArray(int[] numList) {
    for (int value : numList)
        System.out.print(value + "\t");
    System.out.println();
}