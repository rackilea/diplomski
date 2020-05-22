public class Main {

    public static void main(final String args[]) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Enter Test String: ");
        String testString = br.readLine();
        testString = "." + testString + ".";

        testString = testString.replaceAll("[O]+X","X").replaceAll("X[O]+", "X");

        int count = testString.length() - testString.replace("O", "").length();
        System.out.println("Result string:  " + testString);
        System.out.println("Total 'O' left:  " + count);
    }
}