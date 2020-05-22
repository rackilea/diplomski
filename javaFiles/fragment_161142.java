for (i = 1; i <= (totalResults/itemsperPage) + 1; i++) {
    System.out.println("nextPage " + i);
    for (; j < i* itemsperPage; j++) {
        if(j > totalResults) {
           break;
        }
        System.out.println("Filenummer " + (j + 1));
    }
}