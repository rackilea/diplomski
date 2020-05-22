bool hasDuplicates = false;

for (int i = 0; i < BArray.length; i++)
    for (int j = i + 1; j < BArray.length; j++)
        hasDuplicates |= BArray[i] == BArray[j];

...