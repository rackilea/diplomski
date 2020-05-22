String answer = "Yes";
while (answer.equals("Yes"))
{
    System.out.println("Please enter your bill amount.");
    double bill0 = input.nextDouble();

    System.out.println("Is there another customer? (Yes or No)");
    answer = input.nextLine();    
}