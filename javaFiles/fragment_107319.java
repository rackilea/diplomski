import java.util.Random;

public class CarnivalGame
{
public static void main(String[] args)
{
int count = 0;
int wins = 0;
for (int i = 0; i < 100; i++)
{
System.out.println("Roll " + (i + 1));
count = count + 1;
int die1=(dieRoll(6));
int die2=(dieRoll(20));
int die3=(dieRoll(8));
int die4=(dieRoll(4));
int die5=(dieRoll(12));
int sum = die1+die2+die3+die4+die5;
System.out.println("Total:    " +  sum + "\n");

if ((sum >= 35) || (sum < 20)){
System.out.println("Player wins!\n");
wins = wins + 1;
}
if (count == 100){
//FIXED PROBLEM
System.out.printf("After 100 rolls, the player has won for a total of %d times!\n", wins); 
}
}//end for loop
}//end main

public static int dieRoll(int sides)
{ 
   int num = 0;
   int roll = 0;
   Random  rng = new Random(); 
   if(sides >=4) 
      { 
      for(int i = 0; i < 1; i++)
         { 
         roll = rng.nextInt(sides)+1;
         System.out.println("Roll is:  " + roll);
         num = num + roll; 
   }//end for loop
   }//end if
return num;
}//end method   

}//end class