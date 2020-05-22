import java.util.Scanner;
class GolfEM
{
public static void main (String[] args)
{
Scanner kb = new Scanner(System.in);
boolean go = true;
boolean run = true;
while (go==true)
    {
    while (run)
        {
System.out.println("Enter par for the hole: ");
int par = kb.nextInt();
System.out.println("Enter the number of strokes: ");
int stroke = kb.nextInt();


if (stroke==1)  {
System.out.println("hole in one");
run=false;
        }
else
if (3==par-stroke){
System.out.println("double eagle");
run=false;
        }
else
if (2==par-stroke){
System.out.println("eagle");
run=false;
        }
else
if (1==par-stroke){
System.out.println("birdie");
run=false;
        }
else
if (par==stroke){
System.out.println("par");
run=false;
        }
else
if (-1==par-stroke){
System.out.println("bogey");
run=false;
        }
else
if (-2==par-stroke){
System.out.println("double-bogey");
run=false;
        }
else
if (-3==par-stroke){
System.out.println("triple-bogey");
run=false;
        }
else
if (-4==par-stroke){
System.out.println("four-over-par");
run=false;
        }
else
if (-5==par-stroke){
System.out.println("five-over-par");
run=false;
        }
else
if (-6==par-stroke){
System.out.println("six-over-par");
run=false;
        }
else
if (-7==par-stroke){
System.out.println("seven-over-par");
run=false;
        }
else{
System.out.println("Better luck next time");
run=false;
        }
           run=false;
        }


    if (run==false)
    System.out.println("Run again? ");
    char again = kb.next().charAt(0);
        if (again == 'y')
        {
        run=true;}
        else if (again == 'n')
        {
        System.out.println("Goodbye.");
        go = false;}
        else
        {
        System.err.println("Invalid answer");
        }}
    }
  }