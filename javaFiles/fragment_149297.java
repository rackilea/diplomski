public class TestRunner {

    public static void main(String[] args) {

        String sourceString = "{ABCD EFGH IJKL}";
        // Remove brackets...
        String bracketRemoved = sourceString.replaceAll("\\{", "").replaceAll("\\}", "");

        System.out.println("Removed brackets " + bracketRemoved);

        // split by space
        String[] chunks = bracketRemoved.split(" ");

        for (String s : chunks) {
            System.out.println("Processing " + s);

            // substring the last 2 characters of a 4 length String
            System.out.println("s" + s.substring(2, 4));
        }
    }

}