public class Die{

    private int randomValue;

    public Die(){
        this.randomValue = ((int)(Math.random() * 100)%6 + 1);
    }

    public int getValue(){
        return this.randomValue;
    }

    public static void main(String[] args){

        //Create a new object of Die class
        Die dieObject = new Die();

        //Print random value ussing getter method
        System.out.println("The random value is: " + dieObject.getValue());
    }
}