private static void outPutTablePrinter(int numberOfDays,int sharePoints){
//        System.out.println("Day " + " Share Points");
//        System.out.println(1 + "    " + sharePoints);
        for (int i = 2; i <= numberOfDays; i++) {
            if (numberOfDays % 2 == 0)
                if (i <= numberOfDays / 2) {
                    sharePoints = sharePoints + 50;
//                    System.out.println(i + "    " + sharePoints);
                } else {
                    sharePoints = sharePoints - 25;
//                    System.out.println(i + "    " + sharePoints);
                } else {
                if (i <= numberOfDays / 2 + 1) {
                    sharePoints = sharePoints + 50;
//                    System.out.println(i + "    " + sharePoints);
                } else {
                    sharePoints = sharePoints - 25;
//                    System.out.println(i + "    " + sharePoints);
                    // above nested if else statements essentially calculate
                    // and concatenate the variables to obtain an answer that is then printed
                    // and repeated until the number of days is reached (starting from day two)
                }
            }
        }
        System.out.println("The share points on the final day would be: "+sharePoints);
}