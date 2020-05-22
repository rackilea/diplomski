package stackoverflow.fight;
import java.io.BufferedReader;
import java.io.Console;
import java.io.IOException;
import java.io.InputStreamReader;
/**
 * this class runs the fight.
 * 
 * It only deals with the input handling, all the rest is done in Fight.class
 */
public class Main {
    private static enum Command {
    F, // fight
    R, // rest
    B, // buy weapon
    C, // status
    Q, // quit
    UNDEFINED;
}

public static void main(String... args) throws IOException {


    // create the opponents:
    final Opponent goodman = new Opponent("Goodman", 50, false);
    final Opponent monster = new Opponent("Monster", 50, true);

    // and init the fight
    final Fight fight = new Fight(goodman, monster);

    // input switch statement
    // loop while both are alive
    while (fight.isOngoing()) {

        System.out.println("\n" + fight.getTitle());
        System.out.println("\tF: Go out and Fight");
        System.out.println("\tB: Buy Weapon");
        System.out.println("\tR: Rest");
        System.out.println("\tC: Check Stats");
        System.out.println("\tQ: Quit");

        switch (readCommand()) {
        case F:
            System.out.println("f: Continue the fight");
            fight.fight();
            if (!fight.isOngoing()) {
                fight.end();
            }
            break;
        case R:
            fight.rest();

            break;

        case C:
            System.out.println("c: Fight-Status:");
            fight.status();
            break;

        case B:
            System.out.println("b: Buy Weapon:");
            System.out.println(Weapon.getBuyableWeapons());
            Weapon weapon = readWeapon();
            fight.buy(goodman, weapon);
            break;

        case Q:
            System.out.println("q: You quit: Game over");
            System.exit(0);
            break;

        default:
            System.out.println("--> Invalid selection");
            break;
        }

    }

}

private static String readLine(String message) throws IOException {
    System.out.print("> "+ message.trim() +": ");
    // readline from System.in
    final String line =  new BufferedReader(new InputStreamReader(System.in)).readLine();
    if (line == null || "".equals(line.trim())) {
        return readLine(message);
    }
    return line;
}

private static Weapon readWeapon() throws IOException {
    Weapon weapon = Weapon.findByName(readLine("\tChoose your Weapon"));
    if (weapon == null) {
        readWeapon();
    }
    return weapon;
}

private static Command readCommand() throws IOException {

    // transform to Command
    try {
        return Command.valueOf(readLine("Your Comand").toUpperCase());
    } catch (RuntimeException e) {
        // if command is null, empty or not one of F,R,C or Q
        return readCommand(); // No match ... re-read 
    }
}}