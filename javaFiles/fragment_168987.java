public class Questionaire {

    public static void main(String[] args) {

        double bookCost = 0.0;
        int bookAvailable = 0;
        int prosepectiveEnrollment = 0;
        String rOrO = "";    
        String nOrU = "";

        try (Scanner sc = new Scanner(System.in)){
            System.out.println("Welcome to College Store Sale Class.");
            System.out.println("Please enter all the info below as asked.");
            System.out.println("Write either 'Continue' or 'Exit' to continue or exit program respectively. ");

            String ending = sc.next();
            System.out.println("Your response "+ending);

            while(!ending.equalsIgnoreCase("exit")){

                bookCost = promptQuestion("Please enter the cost of book ($>=0).", param -> {
                    return param >= 0;
                }, bookCost,sc);
                System.out.println("Your response "+bookCost);

                bookAvailable = promptQuestion("Please enter the number of books available (n>=0). ", param -> {
                    return param >= 0;
                }, bookAvailable, sc);
                System.out.println("Your response "+bookAvailable);

                prosepectiveEnrollment = promptQuestion("Please enter prospective class enrollement > 0: ", param -> {
                    return param > 0;
                }, prosepectiveEnrollment, sc);
                System.out.println("Your response "+prosepectiveEnrollment);

                rOrO = promptQuestion("Is the book Required or Optional (ignoreCase)? ", param -> {
                    return param.equalsIgnoreCase("Required") || param.equalsIgnoreCase("Optional");
                }, rOrO, sc);
                System.out.println("Your response "+rOrO);

                nOrU = promptQuestion("Is the book New or Used? Enter in 'N' or 'U' format. ", param -> {
                    return (param.equalsIgnoreCase("New") || param.equalsIgnoreCase("Used")
                            || param.equalsIgnoreCase("N") || param.equalsIgnoreCase("U"));
                }, nOrU, sc);
                System.out.println("Your response "+nOrU);

                System.out.println("Write either 'Continue' or 'Exit' to continue or exit program respectively. ");
                ending = sc.next();
                System.out.println("Your response "+ending);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static Integer promptQuestion(String question, Validation<Integer> validation, Integer input, Scanner sc) {
        do {
            System.out.println(question);
            input = sc.nextInt();
        } while(!validation.validate(input));
        return input;
    }

    static Double promptQuestion(String question, Validation<Double> validation, Double input, Scanner sc) {
        do {
            System.out.println(question);
            input = sc.nextDouble();
        } while(!validation.validate(input));
        return input;
    }

    static String promptQuestion(String question, Validation<String> validation, String input, Scanner sc) {
        do { 
            System.out.println(question);
            input = sc.next();
        } while(!validation.validate(input));
        return input;
    }

    @FunctionalInterface
    private static interface Validation<T> {
        boolean validate(T t);
    }
}