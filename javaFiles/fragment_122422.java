import java.util.Scanner;

class Box{

    private Box nestedBox;

    public Box(int numOfInnerBoxes){
        if (numOfInnerBoxes > 0) {
            this.nestedBox = new Box(numOfInnerBoxes - 1);
        }
        System.out.println("This box "+ this +" contains box "+ this.nestedBox +".");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numOfBoxes = sc.nextInt();
        Box outerBox = new Box(numOfBoxes-1);
        System.out.println("The outermost box is "+ outerBox +".");
    }

}