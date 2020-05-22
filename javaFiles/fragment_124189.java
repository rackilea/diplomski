import java.util.Scanner;

public class LifeSimulator {

    static String name;

    public static void Choice1() {

    }

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        LifeSimulator player = new LifeSimulator();
        System.out.println("Welcome to Life Simulator 2017! What is your name?");
        player.name = input.nextLine();
        System.out.println("Hello " + name);

    }

}