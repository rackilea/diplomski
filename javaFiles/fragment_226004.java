public class Mammal {
    private String name;
    public Mammal(String aName) { name = aName; }
    public String getName() { return name;}
    public int getLegs() {return 4; }
    public int getHands() {return 0;}
}

public class FourFootedMammel extends Mammal {
    public FourFootedMammel(String aName) {super(aName);}
}

public class TwoFootedMammal extends Mammal {
    public TwoFootedMammal(String aName) {super(aName); }
    public int getHands() {return 2;}
    public int getLegs() {return 2; }
}   

TwoFootedMammal human = new TwoFootedMammal("Human");
FourFootedMammal dog = new FourFootedMannal("Dog");