public static void main(String [] args) throws InputMismatchException{
    double width;
    int period;
    double Ppp;
    Scanner in0  = new Scanner(System.in);

    System.out.println("Give width\n");
    // This will read the line, and parse the result as a double, this way you can insert a number and press enter
    width = Double.parseDouble(in0.nextLine());

    System.out.println("Give period");
    period = Integer.parseInt(in0.nextLine());

    System.out.println("\n");
    System.out.println("Insert width peak to peak:");
    ppp = Double.parseDouble(in0.nextLine());

    in0.close();
    }