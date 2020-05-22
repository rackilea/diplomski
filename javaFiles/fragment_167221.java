int count = 0;
 do {
    int temp = 0;
    count++;
    for (int i = 0; i < (arrayN.length - 1); i++) {
        if (arrayN[i] > arrayN[i + 1]) {
            temp = arrayN[i];
            arrayN[i] = arrayN[i + 1];
            arrayN[i + 1] = temp;


        }
    }
 } while (count < (arrayN.length));