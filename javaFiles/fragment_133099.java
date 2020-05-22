public class Main {

    public static void main(String[] args) {

        Scanner keyboard = new Scanner(System.in);
        System.out.println("Enter words");

        String ingredients = keyboard.nextLine();

        StringTokenizer str = new StringTokenizer(ingredients, ">:");

        while (str.hasMoreTokens()) {
            String nextToken = str.nextToken();
            String trimmed = nextToken.trim();
            System.out.println(trimmed);
        }

    }
}