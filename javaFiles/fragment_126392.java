public static int checkChoice(int choice) {
Scanner sc = new Scanner(System.in);
if (choice < 1 || choice > 4) {
        System.out.println("Invalid Input");

}else{
        return choice;
}
do {
    System.out.println("Enter your choice (1,2,3 or 4:): ");
    choice = sc.nextInt();
    if (choice < 1 || choice > 4) {
        System.out.println("Invalid Input");

    }
} while (choice < 1 || choice > 4);

return choice;