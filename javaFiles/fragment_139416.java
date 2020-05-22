void reportLine (int lineNum)
{
    Die die1 = new Die(numSides);
    Die die2 = new Die(numSides);
    Die die3 = new Die(numSides);
    Die die4 = new Die(numSides);
    Die die5 = new Die(numSides);

    setDice(die1, die2, die3, die4, die5);
    rollDice();

    System.out.printf("%s.  %s    %s", lineNum, toString(), faceValue(1));
}