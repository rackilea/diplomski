public class RunSugarBowl {
    public static void main(String[] args) {
        SugarBowl one = new SugarBowl(200);
        System.out.println("Sugar overflow: " + Integer.toString(one.addSugar(300))); //once working correctly should print out 100 for the overflow
        System.out.println("Occupied size is : "+ one.occupied());
    }
}