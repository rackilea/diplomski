public static void main(String args[])
{
    boolean loop = true;
    double numberOfStudents;
    Scanner scnr = new Scanner(System.in);

    while(loop){
        System.out.print("Enter a number: ");

        String input = scnr.nextLine();
        try{
            numberOfStudents = Double.parseDouble(input);
            loop = false;
        }catch(NumberFormatException e){
        }
    }
    System.out.println("You're outside the loop!");
}