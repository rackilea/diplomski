import java.util.Scanner;

public class GameDriver {

    public static void Gamer(Scanner s) {

        Game g = new Game();

        String buf = null;

        for (int i = 0; i < 4; i++) {
            System.out.print(g.askQuestion());
            buf = s.nextLine();

            if (g.confirm(buf))
                System.out.println("You're Right!");
            else
                System.out.println("You're Wrong...");
        }

        System.out.println("You got a " + g.getScore());

    }

    public static void main(String a[]) {

        Scanner s = new Scanner(System.in);

        try {

            while (true) {
                System.out.print("Press Enter to continue; Type Exit to quit");

                if (s.nextLine().equalsIgnoreCase("exit")) {
                    s.close();
                    break;
                }

                Gamer(s);
            }

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
}