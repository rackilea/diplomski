String answer = "n";
do
{

...
System.out.printf("\nWould you? ");
answer = <-- Get the user input using System.in -->;

} while (!answer.equalsIgnoreCase("y"))