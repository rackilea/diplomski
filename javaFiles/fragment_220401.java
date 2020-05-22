public static String getQuestion() {
        return "Question #" + questionNumber + ": " + questionString;
    }

    public static void testContract() {
        // This function just returns a string to show that the contract is working.
        BlockchainRuntime.println("This contract is working.");
    }