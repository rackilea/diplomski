class YourClass {

    static String[] commandLineArgs;

    static void amountOfCharsInSentence() {
        int sum=0;
        for (String s: commandLineArgs) { // Use the static member here
            sum+=s.length();
        }
    }

    public static void main(String[] args) {
        commandLineArgs = args;           // Assign the static member here
        amountOfCharsInSentence();
    }
}