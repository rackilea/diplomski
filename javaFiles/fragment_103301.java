public class Rocket {
    protected int cost;

    public int getCost(){ return cost;}
}

public class U1 extends Rocket {
    public U1(){ //constructor
        cost = 1; //setting cost of U1 Rocket
    }

    //if public setter is needed, to set cost with any other specs ...
    public void setCost(Specification spec){
        cost = spec.doSomething();
    }
}

public class U1 extends Rocket {
    public U1(){ //constructor
        cost = 2; //setting cost of U2 Rocket
    }

    //if public setter is needed, to set cost with any other specs ...
    public void setCost(Specification spec){
        cost = spec.doSomething();
    }
}