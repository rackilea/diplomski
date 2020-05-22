while (playAgain) {
    int sp0 = spin();
    int sp1 = spin();
    int sp2 = spin();
    System.out.println(sp0 +"\t"+ sp1 +"\t"+ sp2);
    int answer = evaluate(sp0,sp1,sp2);
    int newCred = answer + credits - 1;
    System.out.println("Your now have "+ newCred + " credits");
    System.out.println("Press y to play again");
    playAgain = "y".equals(input.nextLine());
}