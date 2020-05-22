public static void sortAndPrintCollection(Collection col,String var){   
Collections.sort(col, new cardIdSorter());
        System.out.printf("%-12s", var);
        for(PlayingCard p: col) {
            System.out.print(p);
        }}