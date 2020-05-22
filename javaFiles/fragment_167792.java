Scanner sc = new Scanner(System.in);

public void outputScore(String input) {

    String[] words = input.trim().split("\\s+");

    String satisfied = sc.nextLine();

    if (satisfied.equals("quit")) {
        System.out.println(words[0] + " [" + words[4] + "] | " + words[2] + " [" + words[6] + "]");
    }
}