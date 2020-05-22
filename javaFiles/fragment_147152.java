public static void main(String[] args) throws IOException {
    BufferedReader in = new BufferedReader(new FileReader("Test.txt"));
    Scanner sc = new Scanner(System.in);
    System.out.print("Enter the subtring to look for: ");
    String input = sc.nextLine();
    String[] word = input.split(" ");
    String line = in.readLine();
    int count = 0;
    do {
        for (String string : word) {
            count += (line.length() - line.replace(string, "").length()) / string.length();
        }

        line = in.readLine();
    } while (line != null);
    System.out.print("There are " + count + " occurences of " + Arrays.toString(word) + " in ");
}