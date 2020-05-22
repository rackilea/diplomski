public static void main(String[] args) {

    int families = Integer.parseInt(args[0]);
    int boy;
    int girl;
    int fam2 = 0;
    int fam3 = 0;
    int fam4 = 0;
    int fam5 = 0;
    int total = 0;
    int currentTotal;
    for (int i=0; i < families; i++){
        currentTotal = 0;
        boy = 0;
        girl = 0;
        while ( (boy < 1) || (girl < 1) ){
            if (Math.random() < 0.5) {
                boy = boy + 1;
            }
            else {
                girl = girl + 1;
            }
            currentTotal++;
            total++;
        }
        if (currentTotal == 2){
            fam2++;
        }
        if (currentTotal == 3){
            fam3++;
        }
        if (currentTotal == 4){
            fam4++;
        }
        if (currentTotal >= 5){
            fam5++;
        }
    }
    double average = (double) total / families;
    System.out.println("Average: " + average + " babies were had to get at least one of each sex.");
    System.out.println("Number of families with 2 children: " + fam2);
    System.out.println("Number of families with 3 children: " + fam3);
    System.out.println("Number of families with 4 children: " + fam4);
    System.out.println("Number of families with 5 or more children: " + fam5);
    //System.out.println("The most common number of children was " + common + ".");
}