System.out.println("Player Card: " + player.getValueString() + " of " + player.getSuitString());
System.out.println("Computer Card: " + comp.getValueString() + " of " + comp.getSuitString());
if((comp.getValue()== player.getValue()) && (comp.getSuit() == player.getSuit()))
        // handle redrawing cards here
if(player.getValue() > comp.getValue())
    System.out.println("Player won!");
else if(player.getValue() < comp.getValue())
    System.out.println("Computer won!");
else
    System.out.println("Tie!");