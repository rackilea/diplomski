public static void main(String[] args) {
    System.out.println("SHOPPING. Press -1 to quit anytime.\n");
    int prodCount = 0;

    for(int i=0; i<arrayLength; i++) {
        System.out.print("Product: ");
        productName[i] = keyboard.nextLine();
        if(productName[i].equals("-1"))
            break;

        System.out.print("Price: $");
        productPrice[i] = key.nextFloat();
        if(productPrice[i] < 0)
            break;

        prodCount++;
    }

    System.out.println("\nList of the SHOPPING!\n---------------------");
    for (int j = 0; j < prodCount-1; j++) {

       int iMin = j;
       for (int i = j+1; i < prodCount; i++) {
           if (productPrice[i] < productPrice[iMin]) {
               iMin = i;
           }
       }
       if ( iMin != j ) {
           float temp = productPrice[j];
           productPrice[j] = productPrice[iMin];
           productPrice[iMin] = temp;
           String tempn = productName[j];
           productName[j] = productName[iMin];
           productName[iMin] = tempn;
       }
    }
    for(int i=0; i<prodCount; i++) {
        System.out.printf("Item: %s %.2f\n", productName[i],  productPrice[i]);
    }
}