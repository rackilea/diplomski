public final class CheckingFunctions {
    private static ICheckingFunctions checkFunction;

    public static void registerCheckFunction(ICheckingFunctions checkFunction) {
        CheckingFunctions.checkFunction = checkFunction;
    }

    public static boolean checkName(People ppl){
        return checkFunction.checkName(ppl);
    }

    public static boolean checkAge(People ppl){
        return checkFunction.checkAge(ppl);
    }
}