public static void main(String[] args) {

    // Declare variables
    int[] array1 = {12, 23, -22, 0, 43, 545, -4, -55, 43, 12, 0, -999, -87}, pos, hc;
    int positive = 0, negative = 0;

    // Check how many positive and/or negative numbers
    for (int i : array1)
    {
        if (i >= 0)
        {
            positive++;
        } else 
        {
            negative++;
        }
    }

    // Make exact size arrays
    pos = new int[positive];
    hc = new int[negative];

    // Reset variables for new purpose
    positive = 0;
    negative = 0;

    //Put numbers in correct array
    for (int i : array1)
    {
        if (i >= 0)
        {
            pos[positive] = i;
            positive++;
        } else
        {
            hc[negative] = i;
            negative++;
        }
    }

    // Display arrays
    System.out.print("Starter array: ");
    for (int i: array1)
    {
        System.out.print(" " + i);
    }

    System.out.print("\nPositive array: ");
    for (int i: pos)
    {
        System.out.print(" " + i);
    }

    System.out.print("\nNegative array: ");
    for (int i: hc)
    {
        System.out.print(" " + i);
    }

}