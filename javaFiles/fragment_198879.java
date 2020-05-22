package my.proj.main;

import my.proj.sims.Dice;

public class Main
{
    public static void main(String[] args)
    {
        DiceRoller roller = new DiceRoller();
        roller.rollAndShow(4);
    }
}