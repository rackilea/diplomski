if (vCount[i] > vCount[i+1])
    {
        int temp = vCount[i];
        vCount[i] = vCount[i+1];
        vCount[i+1] = temp;
        hasSwapped = true;
        char temp2 = vArray[i];
        vArray[i] = vArray[i+1];
        vArray[i+1] = temp2;
    }