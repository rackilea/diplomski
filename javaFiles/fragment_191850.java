import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Fraction {
    private final int nom;
    private final int den;
    public Fraction(int nom, int den) {
        if (den <= 0)
            throw new IllegalArgumentException("Invalid denominator: " + den);
        this.nom = nom;
        this.den = den;
    }
    public int getNom() {
        return this.nom;
    }
    public int getDen() {
        return this.den;
    }
    @Override
    public String toString() {
        return (this.den == 1 ? String.valueOf(this.nom) : this.nom + "/" + this.den);
    }

    public static Fraction prompt(Scanner sc, String message) {
        Pattern p = Pattern.compile("\\s*(?:(?:(\\d+)\\s+)?(\\d+)/)?(\\d+)\\s*");
        for (;;) {
            System.out.print(message + ": ");
            String line = sc.nextLine();
            Matcher m = p.matcher(line);
            if (m.matches()) {
                if (m.start(2) == -1)
                    return new Fraction(Integer.parseInt(m.group(3)), 1); // whole number
                int nom = Integer.parseInt(m.group(2));
                int den = Integer.parseInt(m.group(3));
                if (m.start(1) != -1)
                    nom += Integer.parseInt(m.group(1)) * den;
                return new Fraction(nom, den);
            }
            System.out.println("** Not a valid fraction. Please enter values like 2/3 or 4 3/7 or 13");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for (;;) {
            Fraction fraction = Fraction.prompt(sc, "Enter value");
            if (fraction.getNom() == 0)
                break;
            System.out.println("You entered: " + fraction);
        }
    }
}