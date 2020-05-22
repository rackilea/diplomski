for (int j = 0; j <= 90; j = j + 3) {
    if (j == 0) { //Bad idea!!
        if (array[j + 1] % 2 == 0) { //Always false. array[0 + 1] == 1
            System.out.println("        " + array[j + 1] % 2 + "        " + array[j + 1]);
            evenArray[j / 3] = array[j + 1];
        }
        if (array[j + 2] % 2 == 0) { //Always true. array[0 + 2] == 2
            System.out.println("        " + array[j + 2] % 2 + "        " + array[j + 2]);
            evenArray[j / 3] = array[j + 2]; 
        }
    }

    if (array[j] % 2 == 0) {
        System.out.println("        " + array[j] % 2 + "      " + array[j]);
        evenArray[j / 3] = array[j];
    }

}