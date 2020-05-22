for (int i = 0; i < febCount; i++) {
    if (feb[i] % 3 == 0 || feb[i] % 5 == 0 || feb[i] % 7 == 0) { //check if multiple of 3 5 or 7
         System.out.println(" Skip ");
    } else { //if it's not a multiple, then print the number
       System.out.println(" " + feb[i]);
    }
}