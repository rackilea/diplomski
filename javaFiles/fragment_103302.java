public class Rocket {
    private int cost;
    public Rocket(int cost){
        this.cost = cost; //avoid shadowing
    }

    public void doSomethingWithCost(){ ... }
    public int getCost() {...}
}

public class U1 extends Rocket {
    public U1(){
        super(1); //setting default cost of U1 Rocket
    }
    public U1(int cost){
        super(cost); //if you need to set the cost when making new instance of U1
    }

}