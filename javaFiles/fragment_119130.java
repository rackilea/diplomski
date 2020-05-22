public class TotalPoints {

    public static void main(String[] args) {
        int sum = points(args);
        System.out.println(sum);
    }

    public static int points(String[] games) {
        int sum = 0;
        int matches = 10;
        int x = 0;
        int y = 0;
        for (int i = 0; i < games.length; i++) {
            String[] pieces = games[i].split(":");
            x = Integer.parseInt(pieces[0]);
            y = Integer.parseInt(pieces[1]);
        }
        for (int j = 0; j < matches; j++) {
            if (x > y) {
                sum = sum + 3;
            } else if (x == y) {
                sum = sum + 1;
            }
        }
        return sum;
    }
}