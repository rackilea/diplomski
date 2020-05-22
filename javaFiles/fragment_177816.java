public class Car { 
    private int speed; //private variable declaration
    public int wheels; //public variable declaration

    /*...constructor, etc...*/

    public void speedUp() {
        //local variable declaration, in line assignment, only seen within speedUp method
        int speedIncrease = 10;
        speed += speedIncrease;
    }
}