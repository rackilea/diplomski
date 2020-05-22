int index = 7;
    String[][] array = new String[5][10];

    String[][] tempArray = Arrays.copyOf(array, array.length + 1); // New array with row size of old array + 1

    tempArray[array.length] = new String[array[index].length]; // Initializing the new row

    for(i=tempArray.length; i>=index; i--)
    {
        tempArray[i] = tempArray[i-1];
    }

    tempArray[index] = new String[array[index].length];