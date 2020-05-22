Scanner scan = new Scanner(System.in);

while(true) {
    System.out.println("Enter Child's number(s) of Days: ");
    int AGE = scan.nextInt();

    if (AGE == 0 || AGE == 1) {
        System.out.println("Classification: New Born");
    } else if (AGE >= 2 && AGE <= 10) {
        System.out.println("Classification: Infant");
    } else if (AGE > 9 && AGE < 19) {
        System.out.println("Classification: New Born");
    } else if (AGE > 17 && AGE < 37) {
        System.out.println("Classification: TODDLER");
    } else if (AGE > 36 && AGE < 120) {
        System.out.println("Classification: KID");
    } else {
        System.out.println("Classification: Out of Range");
    }
}