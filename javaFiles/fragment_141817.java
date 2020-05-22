public class Dice {
    private String name;
    private int[] values;
    private int rolledValue;
    private java.util.Random random = new java.util.Random();

    // constructor 
    public Dice(int faces,String name){
        int[] values =new int[faces];
        for (int i=0;i<faces;i++){
            values[i]=i+1;
        }
        this.name=name;
        this.values=values;
    }

    public void rollDie() {
        rolledValue = values[random.nextInt(values.length)];
    }

    public int getRolledValue() {
        return rolledValue;
    }
}