if(answer.equals("hit"))         
{
    dealHand();
    Player human = new Player();
    human.calcScore();
    Computer computer = new Coputer();
    computer.calcScore();
    cardTotal ++;
}