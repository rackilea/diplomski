public class DuplicateWords {

    public static void main(String[] args) {

        String regex = "\\b(\\w+)(\\W+(?i:\\1)\\b)+";
        Pattern p = Pattern.compile(regex);

        // OR this one also works
        // String regex = "\\b(\\w+)(\\W+\\1\\b)+";
        // Pattern p = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);

        Scanner in = new Scanner(System.in);
        int numSentences = Integer.parseInt(in.nextLine());

        while (numSentences-- > 0) {
            String input = in.nextLine();

            Matcher m = p.matcher(input);

            // Check for subsequences of input that match the compiled pattern
            if (m.find()) {
                input = m.replaceAll("$1");
            }

            // Prints the modified sentence.
            System.out.println(input);
        }
        in.close();
    }
}