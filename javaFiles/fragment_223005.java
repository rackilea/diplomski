if (choice == 1) {
    System.out.println("How many? ");
    buy = myscanner.nextDouble();
    mywallet.add(buy);
    bitcoin = bitcoin * buy;
    USD = USD - bitcoin;
    System.out.println("you have bought:" + mywallet.numcoins);
    System.out.println(USD);
    bitcoin = 4000; // this line was added
} else if (choice == 2 && USD >= bitcoin) {