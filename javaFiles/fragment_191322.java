public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);

    String userChoice;
    int heightMomFt, heightMomIn, heightDadFt, heightDadIn, genderChild;
    double FemaleChildhFt, MaleChildhFt, FemaleChildhIn, MaleChildhIn;
    while (true) {
        System.out.println("Enter the gender of your future child. Use 1 for female, 0 for male.");
        genderChild = scan.nextInt();

        System.out.println("Enter the height in feet, then the height in inches of the mom.");
        heightMomFt = scan.nextInt();
        heightMomIn = scan.nextInt();

        System.out.println("Enter the height in feet, then the height in inches of the dad.");
        heightDadFt = scan.nextInt();
        heightDadIn = scan.nextInt();

        MaleChildhFt = (heightMomFt * 13 / 12 + heightDadFt) / 2;
        FemaleChildhFt = (heightDadFt + 12 / 13 + heightMomFt) / 2;

        if (genderChild == 1)
            System.out.println(("Your future child is estimated to grow to") + FemaleChildhFt);

        if (genderChild == 0)
            System.out.println(("Your future child is estimated to grow to") + MaleChildhFt);

        System.out.println("Enter 'Y' to run again, anything else to exit.");
        userChoice = scan.next();
        if (userChoice.equals("Y"))
            System.out.println("Continuing...");
        else
            break;
    }
}