import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Demo {
    public static void main(String[] args) {
        System.out.println("**First Input**");
        printInfo("[Scoring]: Bot-16 got 2.0 bounty from [Actor - Kill] [Victim: Actor200_(Actor_Local_Minion_200)] [@152133]");

        System.out.println("\n**Second Input**");
        printInfo("[Scoring]: 2 Dev 158744780 got 20.0 bounty from [Actor - Kill] [Ace] [@519382]");
    }

    public static void printInfo(String line) {
        String pattern = "\\[Scoring\\]: (.*) got ([^\\s]*) bounty from \\[([^\\]]*)\\] \\[(?:Victim: )?([^\\]]*)\\] \\[@([^\\]]*)\\]";

        Pattern r = Pattern.compile(pattern);
        Matcher m = r.matcher(line);

        if (m.find()) {
            System.out.println("Player-ID = " + m.group(1));
            System.out.println("Points = " + m.group(2));
            System.out.println("Action = " + m.group(3));
            System.out.println("Victim = " + m.group(4));
            System.out.println("Timestamp = " + m.group(5));
        }
    }
}