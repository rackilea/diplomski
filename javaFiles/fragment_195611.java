public class Computer {
Computer[] c;
private int id;
private int bet;
private List<Integer> maxId;
private int maxBet;

public void create(int numComps) {
    int i;
    c = new Computer[numComps];
    maxId = new ArrayList<Integer>();
    maxBet = 0;

    for (i = 0; i < numComps; i++) {

        c[i] = new Computer();
        c[i].id = i+1;
        c[i].bet = bet();
        c[i].display();

        if(c[i].bet > maxBet) {
            maxId = new ArrayList<Integer>();
            maxId.add(c[i].id);
            maxBet = c[i].bet;
        }
        else if(c[i].bet == maxBet) {
            maxId.add(c[i].id);
        }
    }
    displayWinners();
}

public int bet() {
    return (int) (Math.random() * 10) + 1;
}

public void display() {
    String name = "Computer " + id;
    System.out.println(name + " bets " + bet);
}

public void displayWinners() {
    System.out.format("Computer %d", maxId.get(0));
    if(maxId.size() > 1) {
        for(int i=1; i<maxId.size(); i++) {
            System.out.format(" and %d", maxId.get(i));
        }
    }
    System.out.format(" with a bet of %d\n", maxBet);
}

public static void main(String[] args) {
    Computer c = new Computer();
    c.create(5);
}

}