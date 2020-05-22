package my.proj.sims;

import java.util.Random; // I used the Random class, but you can also use the Math class if you prefer (java.lang.Math)

public class Dice
{
    public Dice()
    {
    }

    public int roll()
    {
        Random rand = new Random();    
        return rand.nextInt(6) + 1; // Rolls a random number 1-6
    }
}