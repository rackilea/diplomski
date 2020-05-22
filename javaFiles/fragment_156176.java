public class Holes {

    public static void main(String[] args) {

        int holes;

        Scanner sc = new Scanner(System.in);

        int numberOfCases = sc.nextInt(); // Get input as int - not going to
                                            // advance

        String[] testCases = new String[numberOfCases];

        String line = sc.nextLine(); // Move to next

        for (int i = 0; i < numberOfCases; i++) {
            line = sc.nextLine();// Read input as line
            testCases[i] = line;
        }

        sc.close();

        for (String aCase : testCases) {

            holes = 0;

            if (aCase.length() < 100 && !aCase.contains(" ")) {

                for (int j = 0; j < aCase.length(); j++) {

                    char letter = aCase.charAt(j);

                    if (letter == 'A' || letter == 'D' || letter == 'O'
                            || letter == 'P' || letter == 'R') {
                        holes++;
                    }

                    if (letter == 'B') {
                        holes = holes + 2;
                    }
                }

                System.out.println(holes);
            }
        }
    }
}