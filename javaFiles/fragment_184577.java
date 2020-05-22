int jCpt = 0; //To add in evenArray in an orderly manner
for (int j = 0; jCpt < 90 && j < 4000000; ++j) { //Changed this
    if (array[j] % 2 == 0) {
        System.out.println("        " + array[j] % 2 + "      " + array[j]);

        evenArray[jCpt++] = array[j]; //We add alement #j from array to evenArray
        /* Equivalent of 
         * evenArray[jCpt] = array[j];
         * jCpt = jCpt + 1; 
         */
    }
}