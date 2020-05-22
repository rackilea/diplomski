if (args.length < 2) {
    System.out.println("Not enough arguments. System terminating");
} else {
    try {
        int numOne = Integer.parseInt(args[0]);
        int numTwo = Integer.parseInt(args[1]);
        ...
    }
    catch (NumberFormatException numEx) {
        System.out.println("Int arguments expected");
    }
}