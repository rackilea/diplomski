public void displayWeight() {
    calculateBalanceWeights();
    System.out.println("You need "+total+ " weights in total:");
    System.out.println("   "+hundreds +" 100 lbs");
    System.out.println("   "+fifties +"  50 lbs");
    System.out.println("   "+twenties +"  20 lbs");
    System.out.println("   "+tens +"  10 lbs");
    System.out.println("   "+fives +"   5 lbs");
    System.out.println("   "+ones +"   1 lbs");
}