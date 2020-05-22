for (int k = 0; k < array1.length-1; k++) {
        for (int z = 0; z < array1.length-k-1; z++) {
            if (array1[z] > array1[z+1]) {
                temp = array1[z];
                array1[z] = array1[z+1];
                array1[z+1] = temp;
            }
        }
    }