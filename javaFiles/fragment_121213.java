public static void main(String[] args) {
    Scanner input = new Scanner(System.in);


    System.out.print("What would you like to do? \n 1-Create new Human?\n");
    input1 = input.nextInt();
    input.nextLine();

    //Inputs for The NEW HUMAN
    if (input1 == 1) {
        System.out.println("Enter name:");
        String Name = input.nextLine();

        System.out.println("Good! Now enter the age of " + Name + ": ");
        int Age = input.nextInt();
        System.out.println("Well done! Now enter length: ");
        int Length = input.nextInt();
        input.nextLine();

        System.out.println("Finally, is he/she married? ('YES' or 'NO') ");
        isMarried = input.nextLine();

        Human h1 = new Human(Name, Age, Length, "YES".equals(isMarried));
    }
}