while (iAddDiceRoll2 != 7)
{
    if (iAddDice == iAddDiceRoll2)
        {sResults.concat("Congratulations, you win!");
        break;
    }else{
        sResults = "Point is " + iAddDice + "\n";
    }
    iDice1 = (int) (Math.random() *6+1);
    iDice2 = (int) (Math.random() *6+1);
    iAddDiceRoll2 = iDice1 + iDice2;
    sResults.concat("You rolled " + iAddDiceRoll2 + "\n");
}