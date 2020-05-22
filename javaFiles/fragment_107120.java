public class Players {

    private int sum;


    public Players(int sum) {

        this.sum = sum;  // You got the data from `Driver class` here.
        // You got the sum of two dice. Now do whatever you want to.
    }
}  

public class Driver {

    public static void main(String[] args) {

        Dice dye1 = new Dice();
        Dice dye2 = new Dice(); 
        int sum = dye1.throwDice() + dye2.throwDice();
        Players player = new Player(sum);  // Passing the data to Class Players
    }    
}