import java.util.Scanner;

public class Josephus {

public static void main(String[] args) {

    Scanner in = new Scanner(System.in);
    System.out.println("How many players");

    int numPlayers = in.nextInt();
    Link first = new Link(1);
    Link last = new Link(1);

    for (int k = 2; k <= numPlayers; k++) {
        last.next = new Link(k);
        last = last.next;
    }
    last.next = first;
    first.next = last;

    System.out.println("How many skips");
    int m = in.nextInt();

    for (int g = 0; g < numPlayers; g++) {
        for (int k = 0; k <= m; k++)
        {
            last = last.next;
        }
        // last.next;
        last = last.next;
    }

    in.close();
}
}