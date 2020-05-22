int random = 0,guessed=0;
int a;
random = ((int)(Math.random()*100+1));
System.out.println("Guess the number");     
do          
{    
   guessed++;
a = Keyboard.readInt();     
if (a > random) 
{
    System.out.println("Less");
}
if (a == random)
{
    System.out.println("Correct");
    System.out.println("Guessed" +guessed +"times ";
}
if (a < random)
{
    System.out.println("More");
}
}

while (a != random);