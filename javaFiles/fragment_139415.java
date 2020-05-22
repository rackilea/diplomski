void reportLine (int lineNum)
{
    YahtzeeHand hand = new YahtzeeHand(); // second instance created

    Die die1 = new Die(hand.numSides);
    Die die2 = new Die(hand.numSides);
    Die die3 = new Die(hand.numSides);
    Die die4 = new Die(hand.numSides);
    Die die5 = new Die(hand.numSides);

    hand.setDice(die1, die2, die3, die4, die5); // dice added to second instance
    hand.rollDice();

    System.out.printf("%s.  %s    %s", lineNum, hand.toString(), faceValue(1)); // faceValue(1) called for original instance
}