public static void main( String[] args )
{
    Scanner           scan  = new Scanner(System.in);
    ArrayList<Double> myArr = new ArrayList<Double>();
    int               count = 0;

    System.out.println("Enter a number to be averaged, repeat up to 20 times:");

    // we can use a for loop here to break on q and read the next line instead of that while you had here.
    for (String inputs = scan.nextLine() ; !inputs.matches("[qQ]")  ; inputs = scan.nextLine())
    {
        if (count == 20)
        {
            System.out.println("You entered more than 20 numbers, you suck!");
            break;
        }
        try{
            myArr.add(Double.valueOf(inputs));
            count++; //that'S even shorter than count += 1, and does the exact same thing.
            System.out.println("Please enter another number or press Q for your average");
        }
        catch (NumberFormatException e) {
            System.out.println("You entered more than one number, or not a valid number at all.");
            continue; // Skipping the input and carrying on, instead of just starting over. 
                      // If that's not what you want, just stay with what you had here
        }      

    }
    Double average = calculate_average(myArr);
    System.out.println("Your average is: " + average);
}